package com.yanghui.MuchThread;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 死锁 实战demo
 */
public class DeadLockTest {

    public static Object lock_A = new Object();

    public static Object lock_B = new Object();

    public static void main(String[] args) {
        deadLock();
    }

    /**
     * 两个线程互相占用对方的锁 但是又不释放
     */
    public static void deadLock() {
        Thread threadOne = new Thread() {
            @Override
            public void run() {
                synchronized (lock_A) {
                    System.out.println("线程1正在执行步骤AAA");
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {            //得到锁A -》要想释放锁A   得先获取锁B
                        e.printStackTrace();
                    }
                    System.out.println("线程1即将执行步骤BBB");
                    synchronized (lock_B) {
                        System.out.println("线程1 正在执行步骤BBB");
                    }
                }
                System.out.println("线程A 执行完毕");
            }
        };

        Thread threadTwo = new Thread() {
            @Override
            public void run() {
                synchronized (lock_B) {
                    System.out.println("线程2执行执行步骤AAA");
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) { //得到锁B -》想要释放锁B  得先获取锁A
                        e.printStackTrace();
                    }
                    System.out.println("线程2即将执行步骤BBB");
                    synchronized (lock_A) {
                        System.out.println("线程2正在执行步骤BBB");
                    }
                }
                System.out.println("线程B 执行完毕");
            }
        };

        threadOne.start();
        threadTwo.start();

    }

    @Test
    public void test() {
        List<Object> objectList = new ArrayList<>();
        while (true) {
            objectList.add(new Object());
            System.out.println("添加对象个数" + objectList.size());
        }
    }

}
