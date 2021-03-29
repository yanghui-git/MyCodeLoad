package com.yh.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Nio server
 */
public class NioServer {

    //选择器
    private Selector selector;
    //连接通道
    private ServerSocketChannel listenChannel;

    private NioServer(int port) throws Exception {
        selector = Selector.open();
        listenChannel = ServerSocketChannel.open();
        //绑定端口
        listenChannel.socket().bind(new InetSocketAddress(port));
        //设置非阻塞方式
        listenChannel.configureBlocking(false);
        //连接注册到selector
        listenChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public static void main(String[] args) {
        try {
            NioServer nioServer = new NioServer(8088);
            nioServer.listen();
        } catch (Exception e) {
            System.out.println("Nio 服务端启动失败" + e);
        }
    }


    public void listen() throws Exception {
        System.out.println("Nio服务启动成功-------正在监听");
        while (true) {
            if (selector.select() == 0) {
                continue;
            }
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                //监听到不同地事件进行不同的处理
                listenHandler(key);
                //删除当前key 防止重复处理
                iterator.remove();
            }
        }
    }

    /**
     * 监听到不同的事做不同处理
     */
    public void listenHandler(SelectionKey key) {
        SocketChannel sc = null;
        //连接事件处理
        try {
            if (key.isAcceptable()) {
                //连接注册到selector
                sc = listenChannel.accept();
                sc.configureBlocking(false);
                sc.register(selector, SelectionKey.OP_READ);
            }
            //读取事件处理
            if (key.isReadable()) {
                //拿到socket channel
                sc = (SocketChannel) key.channel();
                sc.configureBlocking(false);
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //读取消息
                if (sc.read(buffer) > 0) {
                    String msg = new String(buffer.array());
                    System.out.println("转发消息: " + msg);
                    //将消息转发
                    sendMsgToClient(msg);
                }
            }
        } catch (Exception e) {
            try {
                // 取消注册
                key.cancel();
                // 关闭通道
                sc.close();
            } catch (IOException e1) {
                System.out.println(e1);
            }
        }
    }

    public void sendMsgToClient(String msg) throws Exception {
        for (SelectionKey key : selector.keys()) {
            Channel channel = key.channel();
            if (channel instanceof SocketChannel) {
                SocketChannel targetChanel = (SocketChannel) channel;
                //将msg写入buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer数据写入通道
                targetChanel.write(buffer);
            }
        }
    }


}
