package com.yh.concurrent;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏
 * CyclicBarrier 使用详解
 * https://www.jianshu.com/p/333fd8faa56e
 */
public class CyclicBarrierCompare {

    public static void main(String[] args) {
        System.out.println("start----");
        // CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        //最后一个线程到达要做的任务
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("最后一个到达的是菜鸟是" + Thread.currentThread().getName());
                System.out.println();
            }
        });

        for (int i = 0; i < cyclicBarrier.getParties(); i++) {
            new Thread(new MyThread(cyclicBarrier), String.valueOf(i)).start();
        }
        System.out.println("over-------");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static class MyThread implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public MyThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            Random rand = new Random();
            int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
            try {
                Thread.sleep(randomNum);
                System.out.println("运动员" + Thread.currentThread().getName() + "到达A，正在等待其他人,用时" + randomNum);
                cyclicBarrier.await();
                System.out.println("运动员" + Thread.currentThread().getName() + "到达B，正在等待其他人,用时" + randomNum);
                cyclicBarrier.await();
                System.out.println("运动员" + Thread.currentThread().getName() + "到达C，正在等待其他人，用时" + randomNum);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
