package com.yh.concurrent;

public class ThreadInterruptDemo {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("线程未中断-------");
                }
                // 中断的处理代码……
                System.out.println("线程已中断😭😭😭");
            }
        };

        thread.start();

        //设置3秒 线程interrupt
        try {
            Thread.sleep(3000l);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
