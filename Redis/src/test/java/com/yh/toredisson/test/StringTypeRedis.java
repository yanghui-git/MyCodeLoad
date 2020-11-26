package com.yh.toredisson.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringTypeRedis {

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
     * redisTemplate.opsForValue()-->Redisson.RBucket
     */
    @Test
    public void StringTypeRedis() {
        //redisTemplate.opsForValue()
        redisTemplate.opsForValue().set("StringTest", 22);
        out(redisTemplate.opsForValue().get("StringTest"));
        //  redisTemplate.delete("String-Test");
        RBucket rBucket = redissonClient.getBucket("StringTest-Redisson");
        rBucket.set(100);
        out(rBucket.get());
        //   rBucket.delete();

        List<String> test = Arrays.asList(new String[]{"1", "2"
                , "3", "4", "5", "hahah"});
        redisTemplate.opsForValue().set("StringTest-2", test);
        test = (List<String>) redisTemplate.opsForValue().get("StringTest-2");
        out(test);
        rBucket = redissonClient.getBucket("StringTest-Redisson-2");
        rBucket.set(test);
        test = (List<String>) rBucket.get();
        out(test);
    }


    @Test
    public void StringTypeRedis2() {
        RBucket rBucket=redissonClient.getBucket("StringRedissonHa");
        rBucket.set(new Student("😁😁",20));
        System.out.println(rBucket.get());
    }

}
