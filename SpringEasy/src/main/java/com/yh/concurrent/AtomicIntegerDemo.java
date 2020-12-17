package com.yh.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.jianshu.com/p/d40160015fb1
 */
public class AtomicIntegerDemo {

    static int count = 1000;

    static int a = 0;

    static AtomicBoolean atomicBoolean = new AtomicBoolean(true);

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        //count次并发测试
        try {
            intDemo();
            atomicIntegerTest();

            a = 0;
            casDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void intDemo() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(count);
        //多线程并发对此操作
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a++;
                    countDownLatch.countDown();
                }
            }.start();
        }
        countDownLatch.await();
        System.out.println(a);
    }


    public static void atomicIntegerTest() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(count);
        //多线程并发对此操作
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    atomicInteger.addAndGet(1);
                    countDownLatch.countDown();
                }
            }.start();
        }
        countDownLatch.await();
        System.out.println(atomicInteger);
    }


    /**
     * Cas https://www.jianshu.com/p/ae25eb3cfb5d   乐观锁
     * @throws Exception
     */
    public static void casDemo() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    cas();
                    countDownLatch.countDown();
                }
            }.start();
        }
        countDownLatch.await();
        System.out.println(a);
    }

    public static void cas() {
        if (atomicBoolean.compareAndSet(true, false)) {
            a++;
            atomicBoolean.set(true);
        } else {
            cas();
        }
    }


}
