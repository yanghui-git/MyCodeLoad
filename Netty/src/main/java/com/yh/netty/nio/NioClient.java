package com.yh.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Nio 客户端
 */
public class NioClient {

    //选择器
    private Selector selector;
    //连接通道
    private SocketChannel socketChannel;
    //用户名
    private String username;
    //启动标志
    private boolean flag;

    public static void main(String[] args) {
        System.out.print("请输入用户名: ");
        try {
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            NioClient nioClient = new NioClient("localhost", 8088, username);
            while (true) {
                //发送数据到服务器
                String msg = scanner.nextLine();
                if (msg.equals("exit")) {
                    nioClient.flag = false;
                    nioClient.sendMsgToServer(username + "下线了");
                    nioClient.socketChannel.finishConnect();
                    nioClient.selector.close();
                    break;
                } else {
                    nioClient.sendMsgToServer(msg);
                }
            }
        } catch (Exception e) {
            System.out.println("客户端启动失败");
        }
    }

    public NioClient(String ip, int port, String username) throws Exception {
        this.username = username;
        flag = true;
        selector = Selector.open();
        //连接服务器
        socketChannel = SocketChannel.open(new InetSocketAddress(ip, port));
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //连接注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        //向服务端发送消息
        sendMsgToServer(username + "  上线了");
        // 监听线程
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //循环读取服务端消息
        executor.execute(() -> {
            while (flag) {
                acceptMsgFromServer();
            }
        });
        executor.shutdown();
    }

    //服务端发送消息
    public void sendMsgToServer(String msg) throws Exception {
        msg = username + "：" + msg;
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
    }

    //接收服务端发来的消息
    public void acceptMsgFromServer() {
        try {
            if (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext() && flag) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        sc.read(buffer);
                        String msg = new String(buffer.array());
                        System.out.println(msg.trim());
                        //移除当前key，防止重复操作
                        iterator.remove();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("暴力下线");
        }
    }

}
