package com.yh.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * https://liangyihuai.blog.csdn.net/article/details/83106584?utm_medium=distribute.pc_relevant.none-task-blog-OPENSEARCH-1
 * .control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-OPENSEARCH-1.control
 * Java的CountDownLatch和CyclicBarrier的理解和区别
 */
public class CountDownLatchCompare {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < countDownLatch.getCount(); i++) {
            new Thread(new MyThread(countDownLatch), "玩家" + i).start();
        }
        System.out.println("正在等待所有玩家准备好");
        countDownLatch.await();
        System.out.println("开始游戏 go go go");
    }

    private static class MyThread implements Runnable {
        private CountDownLatch countDownLatch;

        private MyThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Random rand = new Random();
                int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
                Thread.sleep(randomNum);
                System.out.println(Thread.currentThread().getName() + " 已经准备好了, 所使用的时间为 " + ((double) randomNum / 1000) + "s");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
