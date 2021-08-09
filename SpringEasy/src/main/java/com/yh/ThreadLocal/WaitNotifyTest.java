package com.yh.ThreadLocal;

/**
 * 等待 通知机制 Object wait
 * https://blog.csdn.net/weixin_30556871/article/details/114076382?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-1.control&spm=1001.2101.3001.4242
 */
public class WaitNotifyTest {
    public static void main(String[] args) {

        Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程A等待获取lock锁");
                synchronized (lock) {
                    try {
                        System.out.println("线程A将要运行lock.wait()方法进行等待");
                        lock.wait();
                        System.out.println("线程A等待结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程B等待获取lock锁");
                synchronized (lock) {
                    try {
                        System.out.println("线程B将要运行lock.wait()方法进行等待");
                        lock.wait();
                        System.out.println("线程B等待结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程C等待获取lock锁");
                synchronized (lock) {
                    try {
                        System.out.println("线程C将要运行lock.wait()方法进行等待");
                        lock.wait();
                        System.out.println("线程C等待结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程D等待获取lock锁");
                synchronized (lock) {
                    try {
                        System.out.println("线程D将要运行lock.wait()方法进行等待");
                        lock.wait();
                        System.out.println("线程D等待结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程E等待获取lock锁");
                synchronized (lock) {
                    System.out.println("线程E获取了lock锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程E将要运行lock.notify()方法进行通知");
                    /**
                     * 顺序出栈的方式
                     *  先进后出
                     */
                    lock.notifyAll();

                    /**
                     * notify方法只唤醒一个等待（对象的）线程并使该线程开始执行。所以如果有多个线程等待一个对象，这个方法只会唤醒其中一个线程，选择哪个线程取决于操作系统对多线程管理的实现。
                     */
                    //lock.notify();
                    // lock.notify();
                    // lock.notify();
                    //   lock.notify();
                }
            }
        }).start();


    }
}