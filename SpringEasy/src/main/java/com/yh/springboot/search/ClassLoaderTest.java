package com.yh.springboot.search;

public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(ClassLoaderTest.class.getResource(""));
        System.out.println(ClassLoaderTest.class.getResource("/"));
        System.out.println(ClassLoader.getSystemClassLoader().getResource("application.properties"));
        System.out.println(ClassLoader.getSystemClassLoader().getResource("1.txt"));

    }
}
