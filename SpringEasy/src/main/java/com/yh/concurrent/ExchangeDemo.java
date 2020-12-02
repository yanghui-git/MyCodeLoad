package com.yh.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 交互及Exchanger  https://blog.csdn.net/sinat_36246371/article/details/53873693
 */
public class ExchangeDemo {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        new Thread(new Son(exchanger), "Son").start();
        new Thread(new Bab(exchanger), "Bab").start();
    }

    private static class Son implements Runnable {
        private Exchanger<String> exchanger;

        public Son(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                String s = "I am Son";
                System.out.println("当前线程" + Thread.currentThread().getName()
                        + "  使用exchange前::  " + s + "  使用exchange后::  " + exchanger.exchange(s)
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Bab implements Runnable {
        private Exchanger<String> exchanger;

        public Bab(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                String s = "I am Bab";
                System.out.println("当前线程" + Thread.currentThread().getName()
                        + "  使用exchange前::  " + s + "  使用exchange后::  " + exchanger.exchange(s)
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
