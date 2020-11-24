package com.yh.toredisson.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
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
     * opsForValue()
     */
    @Test
    public void one() {
       /* redisTemplate.opsForValue().set("trans-1", 22);
        out(redisTemplate.opsForValue().get("trans-1"));
        redisTemplate.delete("trans-1");

        RBucket rBucket = redissonClient.getBucket("trans-1-red");
        rBucket.set(22);
        out(rBucket.get());
        rBucket.delete();*/

        List<String> test = Arrays.asList(new String[]{"1", "2"
                , "3", "4", "5", "hahah"});
        redisTemplate.opsForValue().set("trans-1", test);
        test = (List<String>) redisTemplate.opsForValue().get("trans-1");
        out(test);


        RBucket rBucket = redissonClient.getBucket("trans-1-red");
        rBucket.set(test);
        test = (List<String>) rBucket.get();
        out(test);
    }


    /**
     * opsForSet
     */
    @Test
    public void two() {
        Set<String> setList = new HashSet<String>
                (Arrays.asList(new String[]{
                        "1", "2", "xixi", "haha", "777"
                }));
        redisTemplate.delete("trans-2");
        redisTemplate.opsForSet().add("trans-2", setList);
        setList = redisTemplate.opsForSet().members("trans-2");
        out(setList);


        RSet rset = redissonClient.getSet("trans-2-red");
        rset.delete();
        rset.addAll(setList);
        setList = rset.readAll();
        out(setList);
    }


    /**
     * opsForHash
     */
    @Test
    public void three() {
        Map map = new HashMap();
        map.put("name", "testName");
        map.put("age", 100);
        redisTemplate.opsForHash().putAll("trans-3", map);
        out(redisTemplate.opsForHash().get("trans-3", "name"));
        map = redisTemplate.opsForHash().entries("trans-3");
        out(map);
        out(redisTemplate.opsForHash().hasKey("trans-3", "age"));
        out("6666666666");


        RMap rmap = redissonClient.getMap("trans-3-red");
        rmap.putAll(map);
        out(rmap.containsKey("name"));
        out(rmap.get("name"));
        map = rmap;
        out(map.toString());
    }

    /**
     * keys* 查找特定前缀的key
     */
    @Test
    public void eight() {
        Set<String> keys = new HashSet<String>();
        //keys = redisTemplate.keys("*");
        // out(keys);
        keys = stringRedisTemplate.keys("trans-*");
        out(keys);
        keys = stringRedisTemplate.keys("*absent*");
        out(keys);

        out("hahhahahahahahah😄😄");

        RKeys rKeys = redissonClient.getKeys();
        Iterator iterator = rKeys.getKeysByPattern("trans-*").iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
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
        redisTemplate.opsForValue().setIfAbsent("absent-1", "haha--fix");
        out(redisTemplate.opsForValue().get("absent-1"));

        RBucket rBucket = redissonClient.getBucket("absent-1-red");
        // rBucket.setIfExists("hahaha");
        rBucket.trySet("hhhaaaakkk");
        out(rBucket.get());

        //  存在则更新
        //   redisTemplate.opsForValue().setIfPresent();
        //  rBucket.setIfExists();
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
        out("hahahhaha----");

        RBitSet rBitSet = redissonClient.getBitSet("test");
        rBitSet.set(6, true);
        rBitSet.set(7, false);
        out(new String(rBitSet.toByteArray()));

    }


    /**
     * 不好替换的方法1 redisTemplate.execute 有关事务????? 是否有必要替换
     */
    @Test
    public void failedOne() {
        redisTemplate.execute(new SessionCallback() {
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.multi();
                redisTemplate.opsForValue().set("exe-1", "exe-1");
                redisTemplate.opsForValue().set("exe-1-1", "exe-1-1");
                out(redisTemplate.opsForValue().get("exe-1"));
                //    out(redisTemplate.opsForValue().get("exe-1-1"));
                return redisOperations.exec();
            }
        });

        out(redisTemplate.opsForValue().get("exe-1"));
        out(redisTemplate.opsForValue().get("exe-1-1"));
    }
}
