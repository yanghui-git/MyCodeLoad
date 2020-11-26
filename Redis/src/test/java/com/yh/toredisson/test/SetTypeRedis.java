package com.yh.toredisson.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SetTypeRedis {

    public void out(Object object) {
        System.out.println(object);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     *  redisTemplate.opsForSet()-->Redisson.RSet
     */
    @Test
    public void SetTypeRedis() {
        Set<String> setList = new HashSet<String>
                (Arrays.asList(new String[]{
                        "1", "2", "xixi", "haha", "777"
                }));
        redisTemplate.delete("SetRedis");
        redisTemplate.opsForSet().add("SetRedis", setList);
        setList = redisTemplate.opsForSet().members("SetRedis");
        out(setList);

        RSet rset = redissonClient.getSet("trans-2-red");
        rset.delete();
        rset.addAll(setList);
        setList = rset.readAll();
        out(setList);
    }

    @Test
    public void SetTypeRedis2() {
        Set<String> test2=new HashSet<String>();
        test2.add("11");
        test2.add("22");

     /*   redisTemplate.delete("haha");
        redisTemplate.opsForSet().add("haha", test2.toArray());
        out(redisTemplate.opsForSet().members("haha"));*/

        redissonClient.getKeys().delete("xixi");
        redissonClient.getSet("xixi").addAll(test2);
        out(redissonClient.getSet("xixi").readAll());

    /*    redisTemplate.delete("set111");
        redisTemplate.opsForSet().add("set111","11");
        redisTemplate.opsForSet().add("set111","22");
        redisTemplate.opsForSet().add("set111","33");
        redisTemplate.opsForSet().add("set111","44");
        out(redisTemplate.opsForSet().members("set111"));
        redisTemplate.opsForSet().remove("set111",test2.toArray());
        out(redisTemplate.opsForSet().members("set111"));*/

      /*  redissonClient.getSet("set222").add("11");
        redissonClient.getSet("set222").add("22");
        redissonClient.getSet("set222").add("33");
        redissonClient.getSet("set222").add("44");
        out( redissonClient.getSet("set222").readAll());
        redissonClient.getSet("set222").removeAll(test2);
        out( redissonClient.getSet("set222").readAll());*/


    }


}
