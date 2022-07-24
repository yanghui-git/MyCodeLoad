package com.yh.ThreadLocal;

import java.time.LocalDateTime;

/**
 * java sleep wait 锁释放
 * https://juejin.cn/post/7067782161012621319
 */
public class WaitAndSleep {

    /**
     * sleep 不释放锁
     * 新线程获取到锁：2022-07-25T01:28:05.829
     * 主线程尝试获取锁：2022-07-25T01:28:07.809
     * 新线程获释放锁：2022-07-25T01:28:15.833
     * 主线程获取到锁：2022-07-25T01:28:15.833
     */
/*    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("新线程获取到锁：" + LocalDateTime.now());
                try {
                    // 休眠 2s
                    Thread.sleep(10000);
                    System.out.println("新线程获释放锁：" + LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // 等新线程先获得锁
        Thread.sleep(2000);
        System.out.println("主线程尝试获取锁：" + LocalDateTime.now());
        // 在新线程休眠之后，尝试获取锁
        synchronized (lock) {
            System.out.println("主线程获取到锁：" + LocalDateTime.now());
        }
    }*/


    /**
     * wait 释放锁
     * 新线程获取到锁：2022-07-25T01:29:26.207
     * 主线程尝试获取锁：2022-07-25T01:29:28.190
     * 主线程获取到锁：2022-07-25T01:29:28.190
     * 新线程获释放锁：2022-07-25T01:29:36.225
     */
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("新线程获取到锁：" + LocalDateTime.now());
                try {
                    // 休眠 2s
                    lock.wait(10000);
                    System.out.println("新线程获释放锁：" + LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // 等新线程先获得锁
        Thread.sleep(2000);
        System.out.println("主线程尝试获取锁：" + LocalDateTime.now());
        // 在新线程休眠之后，尝试获取锁
        synchronized (lock) {
            System.out.println("主线程获取到锁：" + LocalDateTime.now());
        }
    }


}
