package com.yh.netty.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Aio服务端
 */
public class AioServer {

    public void startListen(int port) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
        serverSocketChannel.bind(new InetSocketAddress(port));
        // 接收并处理客户端请求
        serverSocketChannel.accept(null, new ServerHandler(serverSocketChannel));
    }

    public static void main(String[] arg) throws Exception {
        AioServer aioServer = new AioServer();
        aioServer.startListen(8088);
        System.out.println("服务端正在监听.........");
        // 阻塞代码
        System.in.read();
    }
}
