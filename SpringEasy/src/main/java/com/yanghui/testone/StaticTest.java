package com.yanghui.testone;

import org.junit.Test;

public class StaticTest {
    static {
        System.out.println("static function...");
    }

    {
        System.out.println("unstatic function...");
    }

    public StaticTest() {
        System.out.println("construct function...");
    }

    /**
     * 　静态代码块，在虚拟机加载类的时候就会加载执行，而且只执行一次
     * 　　　　非静态代码块，在创建对象的时候（即new一个对象的时候）执行，每次创建对象都会执行一
     */
    public static void main(String[] args) {
        new StaticTest();
        System.out.println();
        new StaticTest();
        System.out.println();
        new StaticTest();
    }

    @Test
    public void staticTestTwo() {
        System.out.println("666");
    }

    public void print1() {

    }

    public static void print2() {

    }
}
