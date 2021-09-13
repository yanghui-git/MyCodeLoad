package com.yh.concurrent;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Java CompletableFuture
 * https://blog.csdn.net/admin123404/article/details/111168902?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-15.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-15.no_search_link
 */
public class CompletableFutureTest {

    /**
     * 传统方式
     * 阻塞或者轮询的方式得到任务的结果
     * https://colobu.com/2016/02/29/Java-CompletableFuture/
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> f = es.submit(() -> {
            // 长时间的异步计算
            Thread.sleep(1000l);
            // 然后返回结果
            return 100;
        });
        while (!f.isDone()) {
            System.out.println("666");
        }
        System.out.println(f.get());
    }

    @Test
    public void test2() throws Exception {
        Instant start = Instant.now();
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();
        });

        long time = future.get();
        System.out.println("time = " + time);
        Instant end = Instant.now();
        System.out.println("总耗时：" + Duration.between(start, end).getSeconds());

    }

    @Test
    public void test3() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if (new Random().nextInt() % 2 >= 0) {
                //   int i = 12 / 0;
                int i1 = 12 / 1;
            }
            System.out.println("run end ...");
        });

        future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void t, Throwable action) {
                System.out.println("执行完成！");
            }

        });

        // runAsync 执行异常的时候就执行此方法
        future.exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable t) {
                System.out.println("执行失败！" + t.getMessage());
                return null;
            }
        });

        TimeUnit.SECONDS.sleep(20);
    }

    @Test
    public void test4() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result = new Random().nextInt(100);
                System.out.println("result1=" + result);
                return result;
            }
        }).thenApply(new Function<Long, Long>() {
            @Override
            public Long apply(Long t) {
                long result = t * 5;
                System.out.println("result2=" + result);
                return result;
            }
        }).thenApply(new Function<Long, Long>() {
            @Override
            public Long apply(Long aLong) {
                System.out.println("result 3=" + aLong);
                return 1000000l;
            }
        });

        long result = future.get();
        System.out.println(result);
    }
}
