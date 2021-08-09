package com.yh.testone;

import org.junit.Test;

/**
 *
 */
public class EqualsTest {

    @Test
    public void hashCodeOne() {
        //https://blog.csdn.net/zhujohnle/article/details/99830656
        // HashCode 本质 该对象在内存空间中 占用的地址
        Student one = new Student();
        System.out.println(one.hashCode());
        Student two = new Student();
        System.out.println(two.hashCode());
        // ==
        System.out.println(one == two);
        two = one;
        System.out.println(two.hashCode());
        System.out.println(one == two);
    }

    @Test
    public void testTwo() {
        String a = new String("aw");
        String b = new String("aw");
        String c = "aa";
        String d = "aa";
        // 应用对象 比较的是内存地址
        System.out.println(a == b);//false
        // 存放于常量池
        System.out.println(c == d);//true
    }

    @Test
    public void testThree() {
        Integer a = 127;
        Integer b = 127;
        //均指向常量池 （-128--127）
        //https://blog.csdn.net/qq_38070608/article/details/78482211
        System.out.println(a == b);

        Integer aa = -128;
        Integer bb = -128;
        System.out.println(aa == bb);

        //
        Integer aaa = 128;
        Integer bbb = 128;
        System.out.println(aaa == bbb);
    }


    class Student {

        private String name;

        private int age;
    }
}
