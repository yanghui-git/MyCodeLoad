package com.yh.netty.util;

public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.equals("") || str.length() == 0;
    }
}
