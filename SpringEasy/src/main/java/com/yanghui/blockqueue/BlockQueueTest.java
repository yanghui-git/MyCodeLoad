package com.yanghui.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Java BlockingQueue demo  https://www.cnblogs.com/aspirant/p/8657801.html
 */
public class BlockQueueTest {

    static BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

    public static void main(String[] args) {
        new Produce().start();
        new Consumer().start();
    }

    static class Produce extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(2000l);
                    blockingQueue.put(i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                Object str = null;
                try {
                    // str = blockingQueue.take();
                    str = blockingQueue.poll(3000l, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // if (str != null)
                System.out.println("正在消费数据" + str);
            }
        }
    }
}
