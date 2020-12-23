package com.yh.tcpudp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Udp Java server demo  https://blog.csdn.net/baidu_32045201/article/details/78021536
 */
public class UdpServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket =
                new DatagramSocket(9876);
        byte[] sendData;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (true) {
            byte[] receiveData = new byte[1024];
            //创建接收数据报包
            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);
            //接收客户端数据报包
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            //获取客户端地址
            InetAddress IPAddress = receivePacket.getAddress();
            if (sentence != null) System.out.println(df.format(new Date()) + " from " + IPAddress + ": " + sentence);
            //获得客户端端口号
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
            //向客户端发送数据报包
            serverSocket.send(sendPacket);
        }
    }
}

