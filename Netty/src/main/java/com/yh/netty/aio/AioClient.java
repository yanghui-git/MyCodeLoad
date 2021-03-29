package com.yh.netty.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * aio客户端
 */
public class AioClient {

    private final ExecutorService executorService;
    // 连接通道
    private AsynchronousSocketChannel socketChannel;
    private AsynchronousChannelGroup channelGroup;
    private final String username;

    public AioClient(String ip, int port, String username) {
        this.username = username;
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        executorService = Executors.newCachedThreadPool();
        try {
            channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
            socketChannel = AsynchronousSocketChannel.open(channelGroup);
            // 连接到远程服务器
            socketChannel.connect(new InetSocketAddress(ip, port)).get();
            send("上线了");
            byteBuffer.clear();
            socketChannel.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    byteBuffer.flip();
                    // 将buff中的内容转换成字符串
                    String content = StandardCharsets.UTF_8.decode(byteBuffer).toString();
                    // 显示从服务器端读取的数据
                    System.out.println(content);
                    byteBuffer.clear();
                    socketChannel.read(byteBuffer, null, this);
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    exc.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String msg) {
        msg = username + "：" + msg;
        try {
            socketChannel.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8))).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.print("请输入用户名: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        AioClient client = new AioClient("localhost", 8088, username);
        while (true) {
            // 发送数据到服务端
            String msg = scanner.nextLine();
            if (msg.equals("exit")) {
                client.send("下线了");
                client.channelGroup.shutdown();
                client.executorService.shutdown();
                break;
            } else {
                client.send(msg);
            }
        }
    }
}