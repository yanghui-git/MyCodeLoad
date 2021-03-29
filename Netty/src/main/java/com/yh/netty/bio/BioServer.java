package com.yh.netty.bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Bio 服务端
 */
public class BioServer {
    public static void main(String[] args) {
        try {
            //创建服务端socket
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("Bio 服务端启动成功");
            //阻塞
            Socket socket = serverSocket.accept();
            //创建消息处理器
            new BioServerHandler(socket);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
