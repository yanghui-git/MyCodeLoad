package com.yh.toredisson.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HashTypeRedis {

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
     * redisTemplate.opsForHash()-->Redisson.RMap
     */
    @Test
    public void HashTypeRedis() {
        Map map = new HashMap();
        map.put("name", "testName");
        map.put("age", 100);
        redisTemplate.opsForHash().putAll("MapRedis", map);
        out(redisTemplate.opsForHash().get("MapRedis", "name"));
        map = redisTemplate.opsForHash().entries("MapRedis");
        out(map);
        out(redisTemplate.opsForHash().hasKey("MapRedis", "age"));


        RMap rmap = redissonClient.getMap("MapRedis-Redisson");
        rmap.putAll(map);
        out(rmap.containsKey("name"));
        out(rmap.get("name"));
        map = rmap;
        out(JSON.toJSONString(map));
    }


}
