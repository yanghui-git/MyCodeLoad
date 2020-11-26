package com.yanghui.testone;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {


    @Test
    public void DateTestDemo(){
        String fileName ="test";
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");
        fileName += "-" + ft.format(dNow);
        System.out.println(fileName);
        System.out.println("c02c65275d2611eaac8e005056b93035".length());
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }

}
