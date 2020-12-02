package com.yh.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/joenqc/article/details/76794356?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1.control
 * <p>
 * CountDownLatch   CountDownLatch能够使一个线程在等待另外一些线程完成各自工作之后，再继续执行。
 * 使用一个计数器进行实现。
 * 计数器初始值为线程的数量。
 * 当每一个线程完成自己任务后，计数器的值就会减一。
 * 当计数器的值为0时，表示所有的线程都已经完成了任务，然后在CountDownLatch上等待的线程就可以恢复执行任务
 */
public class CountDownLatchDemo {


    public static void main(String[] args) {
        try {
            // noCountDownLatch();
            CountDownLatch();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void noCountDownLatch() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int k = 30;
        for (int i = 0; i < k; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("haha");
                }
            });
        }
        System.out.println("66666666666666666");
        executorService.shutdown();
    }


    /**
     * 使用countDownLatch
     *
     * @throws Exception
     */
    public static void CountDownLatch() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int k = 30;
        final CountDownLatch countDownLatch = new CountDownLatch(k);
        for (int i = 0; i < k; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("haha");
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("66666666666666666");
        executorService.shutdown();
    }

}
