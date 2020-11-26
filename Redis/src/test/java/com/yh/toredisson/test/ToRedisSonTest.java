package com.yh.toredisson.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBitSet;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * 主要是redis template转redisson的一些方法测试
 */
public class ToRedisSonTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void out(Object object) {
        System.out.println(object);
    }


    /**
     * 设置过期时间
     */
    @Test
    public void five() {
        redisTemplate.opsForValue().set("expire-1", "66", 10000, TimeUnit.MILLISECONDS);
        redissonClient.getBucket("expire-1-red").set("66-red", 10000, TimeUnit.MILLISECONDS);
    }

    /**
     * setIFAbsent
     */
    @Test
    public void six() {
        //如果键不存在则新增,存在则不改变已经有的值
        // redisTemplate.opsForValue().setIfAbsent("absent-1", "haha--fix");
        // out(redisTemplate.opsForValue().get("absent-1"));

        RBucket rBucket = redissonClient.getBucket("absent-1-red");
        rBucket.setIfExists("hahaha");
        rBucket.trySet("hhhaaaakkk");
        out(rBucket.get());
        //  存在则更新
        //   redisTemplate.opsForValue().setIfPresent();
        //  rBucket.setIfExists();
    }

    @Test
    public void server7() {
        RBucket rBucket = redissonClient.getBucket("set666");
        rBucket.delete();
        //rBucket.set("888");
        out(rBucket.get());
        //存在则更新
        rBucket.setIfExists("777");
        out(rBucket.get());
    }

    @Test
    public void server8() {
        RBucket rBucket = redissonClient.getBucket("set777");
        rBucket.set("777");
        out(rBucket.get());
        rBucket.delete();
        rBucket.trySet("888");
        out(rBucket.get());
    }

    /**
     * redis bitSet()
     * a--b
     * https://www.cnblogs.com/qjweg/p/10405469.html
     */
    @Test
    public void nine() {
        stringRedisTemplate.opsForValue().set("bitSet-1", "a");
        out(stringRedisTemplate.opsForValue().get("bitSet-1"));
        //a--->b    01100001 变成 01100010
        //  stringRedisTemplate.opsForValue().setBit("bitSet-1", 6, true);
        //  stringRedisTemplate.opsForValue().setBit("bitSet-1", 7, false);
        // out(stringRedisTemplate.opsForValue().get("bitSet-1"));

        RBitSet rBitSet = redissonClient.getBitSet("test");
        rBitSet.set(6, true);
        rBitSet.set(7, false);
        out(new String(rBitSet.toByteArray()));

    }
}
