package com.yh.toredisson.pipline;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * redis 管道技术
 */
public class PipeLineTest {

    public Jedis getJedis() {
        Jedis jedis = new Jedis("10.20.178.137", 6379);
        jedis.auth("123456");
        return jedis;
    }

    @Test
    public void comPare() {
        noPipeLine();
        pipeLine();
    }

    public void noPipeLine() {
        Jedis jedis = getJedis();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            jedis.set("test" + String.valueOf(i), String.valueOf(i));
        }
        System.out.println("未使用管道耗时----");
        System.out.println(System.currentTimeMillis() - start);
    }

    public void pipeLine() {
        Jedis jedis = getJedis();
        Pipeline pipeline = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            pipeline.set("test-pipline" + String.valueOf(i), String.valueOf(i));
        }
        //获取所有操作结果
        List<Object> objects = pipeline.syncAndReturnAll();
        System.out.println("使用管道耗时----");
        System.out.println(System.currentTimeMillis() - start);
        for (Object object : objects) {
            System.out.println(object);
        }

    }
}
