package com.yh.concurrent;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java Lock demo   https://www.cnblogs.com/dolphin0520/p/3923167.html
 */
public class LockTest {

    private static int count = 100;

    private static int n = 1;

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Set<Callable<String>> set = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int thread = i;
            set.add(new Callable() {
                @Override
                public Object call() throws Exception {
                    //   lock(thread);
                    tryLock(thread);
                    return null;
                }
            });
        }
        try {
            executorService.invokeAll(set);
        } catch (Exception e) {
            //e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }

    /**
     * lock 方法模拟
     *
     * @param i
     */
    public static void lock(int i) {
        try {
            //获取锁
            lock.lock();
            System.out.println(i + "获取到锁～～" + new Date() + "    :" + n++);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }

    }

    /**
     * tryLock demo
     */
    public static void tryLock(int i) {
        try {
            Thread.sleep(1000l);
            boolean isGetLock = lock.tryLock();
            if (!isGetLock) {
                System.out.println(i + "没有获取到锁");
                return;
            }
            System.out.println(i + "😄😄 获取到锁了   :" + n++);
            // lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
