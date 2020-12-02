package com.yh.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量Semaphore https://www.cnblogs.com/whgw/archive/2011/09/29/2195555.html
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //设置只能3个线程同时访问  即最大3人同时蹲坑
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            int index = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    // 获取许可
                    try {
                        semaphore.acquire();
                        System.out.println("第" + index + "号" + "正在蹲坑");
                        Thread.sleep((long) (Math.random() * 10000));
                        //访问完成后，释放
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //  System.out.println("-----------------" + semaphore.availablePermits());
                    System.out.println("-----------------第" + index + "号" + "蹲坑结束");
                }
            };
            executorService.submit(runnable);
        }
        executorService.shutdown();
    }


}
