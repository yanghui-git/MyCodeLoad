package com.yh.redission.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTest {

    @Autowired
    private RedissonClient redissonClient;


    @Test
    public void one(){
        System.out.println(redissonClient);
    }
}
