package com.yh.netty.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * aio服务端消息处理器
 */
public class ServerHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {

    // 客户端通道列表
    private static final List<AsynchronousSocketChannel> CHANNEL_LIST = new ArrayList<>();
    private final AsynchronousServerSocketChannel serverSocketChannel;


    public ServerHandler(AsynchronousServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    /**
     * 当实际IO操作完成时触发
     */
    @Override
    public void completed(AsynchronousSocketChannel result, Object attachment) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        CHANNEL_LIST.add(result);
        serverSocketChannel.accept(null, this);
        result.read(byteBuffer, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer result1, Object attachment) {
                        byteBuffer.flip();
                        // 获取消息输出
                        String msg = StandardCharsets.UTF_8.decode(byteBuffer).toString();
                        System.out.println("转发消息: " + msg);

                        // 分发消息
                        try {
                            for (AsynchronousSocketChannel asc : CHANNEL_LIST) {
                                if (asc.isOpen()) {
                                    asc.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8))).get();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        byteBuffer.clear();
                        result.read(byteBuffer, null, this);
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        // 从该Channel中读取数据失败，将该Channel删除
                        CHANNEL_LIST.remove(result);
                    }
                }
        );
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        exc.printStackTrace();
    }
}