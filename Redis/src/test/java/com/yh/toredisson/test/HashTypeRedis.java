package com.yh.toredisson.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
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
        // rmap.remove("name");
        map = rmap;
        out(JSON.toJSONString(map));
    }


    @Test
    public void HashTypeRedis2() {
        Map map = new HashMap();
        map.put("1", new Student("hash1", 20));
        map.put("2", new Student("hash2", 22));
        map.put("3", 33);
       /* RMap rmap = redissonClient.getMap("HashMapStudent");
        rmap.putAll(map);
        rmap.put("hash3",33);
        out(rmap.containsKey("hash3"));
        out(rmap.get("hash3"));
        // rmap.remove("name");
        rmap.remove("1");
        map=rmap.readAllMap();
        out(map);
*/
        redisTemplate.opsForHash().putAll("jj", map);
        map = redisTemplate.opsForHash().entries("jj");
        out(map);

    }


    @Test
    public void deleteKey() {
        Map map = new HashMap();
        map.put("name", "name1");
        map.put("age", 20);
        map.put("haha", "haha");
        redisTemplate.delete("mapdel");
        redisTemplate.opsForHash().putAll("mapdel", map);
       out( redisTemplate.opsForHash().delete("mapdel", new String[]{
                "name", "age", "xixi"
        }));
        out(redisTemplate.opsForHash().get("mapdel", "name"));
        out(redisTemplate.opsForHash().get("mapdel", "age"));
        out(redisTemplate.opsForHash().get("mapdel", "haha"));


        redissonClient.getMap("mapredis").putAll(map);
        String a = redissonClient.getMap("mapredis").remove("name").toString();
        out(a);
        String b=redissonClient.getMap("mapredis").remove("haha").toString();
        out(b);
        out(redissonClient.getMap("mapredis").get("name"));
        out(redissonClient.getMap("mapredis").get("age"));
        out(redissonClient.getMap("mapredis").get("haha"));

    }

}
