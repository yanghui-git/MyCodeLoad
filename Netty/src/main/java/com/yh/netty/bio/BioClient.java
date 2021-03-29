package com.yh.netty.bio;

import com.yh.netty.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Bio客户端
 */
public class BioClient {
    public static void main(String[] args) {
        try {
            //连接服务器
            Socket socket = new Socket("localhost", 8088);
            System.out.println("Bio 客户端启动成功");
            //发送有关
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            //接收有关
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(inputStreamReader);
            //
            System.out.println("请输入向服务端发送的消息: ");
            while (true) {
                //接收的消息
                String request = new BufferedReader(new InputStreamReader(System.in)).readLine();
                if (!StringUtils.isEmpty(request)) {
                    printStream.println(request);
                    String response = br.readLine();
                    System.out.println("GG:  "+response);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
