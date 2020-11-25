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

        RSet rset = redissonClient.getSet("SetRedis-Redisson");
        rset.delete();
        rset.addAll(setList);
        setList = rset.readAll();
        out(setList);
    }

}
