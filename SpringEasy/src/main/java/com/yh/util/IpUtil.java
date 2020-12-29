package com.yh.util;

import org.junit.Test;

import java.net.InetAddress;

public class IpUtil {

    /**
     * 获取本机ip
     */
    @Test
    public void one() {
        InetAddress ia = null;
        try {
            ia = ia.getLocalHost();
            String localname = ia.getHostName();
            String localip = ia.getHostAddress();
            System.out.println("本机名称是：" + localname);
            System.out.println("本机的ip是 ：" + localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
