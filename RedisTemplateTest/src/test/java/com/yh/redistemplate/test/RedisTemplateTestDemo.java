package com.yh.redistemplate.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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
        //   redisTemplate.opsForHash().put("hash-redis", "name", "hash1");
        //   redisTemplate.opsForHash().put("hash-redis", "age", "hash2");
        //    redisTemplate.opsForHash().put("hash-redis-two", "name", "hash11");
        //     //1⃣️map形式添加键值对
        Map map = new HashMap();
        map.put("name", "hash-map");
        map.put("age", "hash-age");
        map.put("age-map", "66");
        redisTemplate.opsForHash().putAll("hash-redis-map", map);

        //获取值
      /*  System.out.println(JSON.toJSONString(
                redisTemplate.opsForHash().get("hash-redis", "name")));*/
        System.out.println(JSON.toJSONString(
                redisTemplate.opsForHash().entries("hash-redis-map")
        ));

        //    Map map1 = redisTemplate.opsForHash().entries("hash-redis-map");
        //   System.out.println(JSON.toJSONString(map1));

        //    System.out.println(redisTemplate.opsForHash().hasKey("hash-redis", "name"));

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

    @Test
    public void four() {
        redisTemplate.execute(new SessionCallback() {
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.multi();
                redisTemplate.opsForValue().set("exe-one", 22);
                redisTemplate.opsForValue().set("exe-two", 33);
                return redisOperations.exec();
            }
        });
    }

    @Test
    public void five() {
        redisTemplate.opsForSet().add("set-redis", Arrays.asList(new String[]{
                "test1", "test2", "test3", "test1"
        }));
        Set<String> list = redisTemplate.opsForSet().members("set-redis");
        System.out.println(list);
    }

    @Test
    public void six() {
        System.out.println(stringRedisTemplate.keys("*"));
    }

    @Test
    public void server() {
        // 如果键不存在则新增,存在则不改变已经有的值
        // redisTemplate.opsForValue().setIfAbsent("absent-test", "hahahaha");
        // redisTemplate.opsForValue().setIfAbsent("absent-test", "xixixi");
        // redisTemplate.opsForValue().setIfAbsent("absent-test-2", "xixiix2");
        //  redisTemplate.opsForValue().set("easy-test", "easy-test", 20000, TimeUnit.MILLISECONDS);
        // System.out.println(redisTemplate.opsForValue().get("easy-test"));
    }

    @Test
    public void nine() {
        redisTemplate.opsForValue().setBit("bit-redis", 1l, true);
        System.out.println(redisTemplate.opsForValue().getBit("bit-redis", 1l));
        redisTemplate.opsForValue().setBit("bit-redis", 1l, false);
        System.out.println(redisTemplate.opsForValue().getBit("bit-redis", 1l));
    }
}
