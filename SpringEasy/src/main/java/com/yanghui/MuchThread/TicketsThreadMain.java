package com.yanghui.MuchThread;

/**
 * java 并发编程demo 模拟火车站买票  synchronized处理
 */
public class TicketsThreadMain {
    //设置总票数
    private static int num = 30;

    private static Object lock = new Object();

    public static void main(String[] args) {
        TicketsThread ticketsThread = new TicketsThread();
        ticketsThread.setName("线程1");
        TicketsThread ticketsThread2 = new TicketsThread();
        ticketsThread2.setName("线程2");
        ticketsThread.start();
        ticketsThread2.start();
    }

    /**
     * 并发问题
     */
//    static class TicketsThread extends Thread {
//
//        @Override
//        public void run() {
//            while (true) {
//                if (num > 0) {
//                    //卖票
//                    num--;
//                    System.out.println("线程" + Thread.currentThread().getName() + "卖票成功当前剩余" + num);
//                    try {
//                        Thread.sleep(100L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }


    /**
     * synchronized 加在处理代码上
     */
//    static class TicketsThread extends Thread {
//
//        @Override
//        public void run() {
//            while (true) {
//                synchronized (lock) {
//                    if (num > 0) {
//                        //卖票
//                        num--;
//                        System.out.println("线程" + Thread.currentThread().getName() + "卖票成功当前剩余" + num);
//                        try {
//                            Thread.sleep(100L);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        }
//    }


    /**
     * synchronized 加在处理方法
     */
    static class TicketsThread extends Thread {

        @Override
        public void run() {
            while (true) {
                getTicket();
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public synchronized static void getTicket() {
        if (num > 0) {
            //卖票
            num--;
            System.out.println("线程" + Thread.currentThread().getName() + "卖票成功当前剩余" + num);
        }

    }

}