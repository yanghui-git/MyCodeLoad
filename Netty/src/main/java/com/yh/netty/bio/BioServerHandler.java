package com.yh.netty.bio;

import com.yh.netty.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Bio 消息处理器i
 */
public class BioServerHandler {

    public BioServerHandler(Socket socket) throws Exception {
        //接收有关
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(inputStreamReader);
        //返回有关
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        System.out.println("Bio 服务端开始接收消息");
        //循环执行
        while (true) {
            //读取客户端消息
            String request = br.readLine();
            if (!StringUtils.isEmpty(request)) {
                System.out.println("MM:  " + request);
                //System.out.println("请输入你的回复信息： ");
                String response = new BufferedReader(new InputStreamReader(System.in)).readLine();
                printWriter.println(response);
            }
        }
    }
}
