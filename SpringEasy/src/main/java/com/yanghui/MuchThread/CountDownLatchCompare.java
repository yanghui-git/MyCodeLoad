package com.yanghui.MuchThread;

import com.yanghui.jackson.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchCompare {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        //  for(int i=0;i<countDownLatch.getCount();i)
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
