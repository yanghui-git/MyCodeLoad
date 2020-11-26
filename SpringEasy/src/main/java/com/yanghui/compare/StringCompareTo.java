package com.yanghui.compare;

import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class StringCompareTo {

    /**
     * ASCII表 https://baike.baidu.com/item/ASCII/309296?fromtitle=ascii%E7%A0%81&fromid=99077&fr=aladdin
     * <p>
     * 48～57 --》0——9
     * 65~90 --》A-Z
     * 97~122 --》a-z
     * <p>
     * 如果是两个字符串比较大小呢？在计算机中，两个字符串比较大小，是按照从左到右的顺序进行比较，如果第1位相等，就比较第2位，直至有一位可以比较出大小来，则不再继续比较。
     */
    @Test
    public void One() {
        System.out.println("qwe".compareTo("asd"));  //q是113   a是97   。113-97=16
        System.out.println("201801".compareTo("201802"));//前五位相同 ， 1是49,2是50,49-50=-1

        System.out.println("3".compareTo("A")); // 51-65
        System.out.println("1422".compareTo("5")); //49-53
        System.out.println("555".compareTo("3")); //53-51

       // System.out.println(Long.parseLong("3.36"));
       // System.out.println(Double.parseDouble("3.45"));

      //  System.out.println(Double.parseDouble("1.42") - Double.parseDouble("5.2"));
        String ss= String.format("对象序列化失败,对象%s,失败原因 %s,姓名 %s","222","3","yyhh");
        System.out.println(ss);
    }
}
