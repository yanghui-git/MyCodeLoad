package com.yh.ThreadLocal;

import org.junit.Test;

/**
 * Java Join 方法探究
 * https://zhuanlan.zhihu.com/p/258581678
 * <p>
 * t1.join(); 底层调用
 * <p>
 * // 等待一段指定的时间
 * t1.join(1000);
 *
 * oepn_jdk 源码：thread.cpp static void ensure_join(JavaThread* thread)
 */
public class TestJoin {

    static int count = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("t1线程 执行");
                count = 10;
            }
        };

        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main...." + count);
    }


    @Test
    public void test() throws Exception {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
                System.out.println("t1.....");
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    // 使t1先执行 等t1结束后 再执行t2 持续等待 while() t1----t2
                    //t1.join();


                    // 等待一段指定的时间   t2----t1
                    t1.join(1000);
                } catch (Exception e) {
                    // e.printStackTrace();
                }
                System.out.println("t2.....");
            }
        };

        t1.start();
        t2.start();
        System.in.read();
    }
}
