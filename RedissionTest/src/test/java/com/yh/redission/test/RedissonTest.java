package com.yh.redission.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void testOne() {
        RBucket rBucket = redissonClient.getBucket("test-rdb222");
        rBucket.set("888");
    }

    /**
     * 感觉像对hash操作
     */
    @Test
    public void one() {
        //操作数据
        RMap rMap = redissonClient.getMap("redisson-1");
        rMap.put("name", "redisson-name");
        rMap.put("age", 22);
        //
        out(rMap.containsKey("name"));
        out(rMap.get("age"));

    }


    public static void out(Object object) {
        System.out.println(object);
    }

    /**
     * 感觉像对set
     */
    @Test
    public void two() {
        RSet reset = redissonClient.getSet("redisson-set");
        reset.add("1");
        reset.add("2");
        reset.add("3");
        reset.add(100);
        out(reset.contains(100));
        out(reset.contains("2"));


        RSortedSet<String> sortedSet = redissonClient.getSortedSet("mySortedSet");
        sortedSet.add("6");
        sortedSet.add("0");
        sortedSet.add("72");
        sortedSet.add("9");
        for (String string : sortedSet) {
            out(string);
        }
        out(sortedSet.last());
        out(sortedSet.first());
    }

    /**
     * 可用作key-value
     */
    @Test
    public void three() {
        RBucket<Long> rBucket = redissonClient.getBucket("bucket-string-test");
        // rBucket.set("444");
        rBucket.set(3l);
        out(rBucket.get());

        rBucket = redissonClient.getBucket("bucket-test-two");
        //设置过期时间
        rBucket.set(55l, 20000, TimeUnit.MILLISECONDS);
        out(rBucket.get());
    }

    class Student {
        String name;
        String age;

        public Student() {

        }

        public Student(String name, String age) {
            this.age = age;
            this.name = name;
        }

    }

    @Test
    public void five() {
        RQueue<String> queue = redissonClient.getQueue("myQueue-redis");
        queue.delete();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.contains("1");
        //out(queue.peek());
        // out(queue.poll());
        out(queue.element());

        queue.remove("3");

        out("-------hahahahha");
        for (String string : queue) {
            out(string);
        }

    }

    @Test
    public void six() {
        System.out.println("22".concat("yh"));
    }
}
