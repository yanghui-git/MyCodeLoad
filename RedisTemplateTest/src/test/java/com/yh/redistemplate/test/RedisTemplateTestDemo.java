package com.yh.redistemplate.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://blog.csdn.net/sinat_22797429/article/details/89196933   redis template操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTestDemo {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * hash
     */
    @Test
    public void one() {
        //新增hashmap
        redisTemplate.opsForHash().put("hash-redis", "name", "hash1");
        redisTemplate.opsForHash().put("hash-redis", "age", "hash2");
        redisTemplate.opsForHash().put("hash-redis-two", "name", "hash11");
        //1⃣️map形式添加键值对
        Map map = new HashMap();
        map.put("name", "hash-map");
        map.put("age", "hash-age");
        redisTemplate.opsForHash().putAll("hash-redis-map", map);

        //获取值
      /*  System.out.println(JSON.toJSONString(
                redisTemplate.opsForHash().get("hash-redis", "name")));*/
        System.out.println(JSON.toJSONString(
                redisTemplate.opsForHash().entries("hash-redis")
        ));

        Map map1 = redisTemplate.opsForHash().entries("hash-redis-map");
        System.out.println(JSON.toJSONString(map1));

        System.out.println(redisTemplate.opsForHash().hasKey("hash-redis", "name"));

        // redisTemplate.opsForHash().delete("hash-redis", "name");
        //redisTemplate.delete("hash-redis");
    }

    /**
     * value easy
     */
    @Test
    public void two() {
        // redisTemplate.opsForValue().set("value-test", 1);
        // redisTemplate.opsForValue().set("value-test-2", 2);
        //判断某键是否存在
        //  System.out.println(redisTemplate.hasKey("value-test"));
        //  redisTemplate.delete("value-test");
        List<Object> testList = new ArrayList<Object>();
        testList.add(1);
        testList.add("2");
        testList.add("yh");
        redisTemplate.opsForValue().set("list-redis", testList);
        List result = (List) redisTemplate.opsForValue().get("list-redis");
        System.out.println(result);
    }

    /***
     * String redis template
     */
    @Test
    public void three() {
        stringRedisTemplate.opsForValue().set("string-redis-t", "2");
        System.out.println(
                stringRedisTemplate.opsForValue().get("string-redis-t"));
    }
}
