package com.yanghui.testone;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期与时间戳
 */
public class DateSimTest {


    @Test
    public void tranTime() {
        long test = System.currentTimeMillis();
        Date date = new Date(test);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("时间戳转具体日期");
        System.out.println(simpleDateFormat.format(date));
        System.out.println("4b43098369aa11eaac8e005056b93035".length());
    }


    @Test
    public void transTime() throws ParseException {
        System.out.println(new Date().getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ss = "2020-03-19 15:57:01";
        //  System.out.println(simpleDateFormat.parse(ss));
        Date date = simpleDateFormat.parse(ss);
        System.out.println(date.getTime());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sss = "2020-08-18 ";
        System.out.println(dateFormat.parse(sss).getTime());

        System.out.println("1".compareTo("0"));
    }


    @Test
    public void getIp() {
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

    @Test
    public void compare() {
        List<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(8);
        test.add(7);
        List<Integer> result = new ArrayList<>();
        Collections.sort(test, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // 2020-08-24 11:12:32
        List<String> strings = new ArrayList<>();
        strings.add("2020-08-24 11:12:32");
        strings.add("2020-08-28 11:12:32");
        strings.add("2020-08-29 11:12:32");
        strings.add("2020-08-29 11:12:21");
        strings.add("2020-08-29 11:14:21");
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });


        System.out.println(test);
        System.out.println(strings);
    }

    @Test
    public void compare2() {
        JSONArray JS=new JSONArray();
        JS.add("1");
        JS.add("2");
        JS.add(1);
        List<String> test=new ArrayList<>();
        test.add("dd");
        test.add("ee");

        List<Integer> integers=Arrays.asList(new Integer[]{1,2,3});
        JS.add(55);
        JS.add(test);
        JS.add(integers);
        System.out.println(JSON.toJSONString(JS));

    }


}



