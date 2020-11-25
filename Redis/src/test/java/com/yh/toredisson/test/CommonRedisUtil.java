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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonRedisUtil {

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
     * search key 搜索key
     * stringRedisTemplate.keys--> redissonClient.getKeys().getKeysByPattern()
     */
    @Test
    public void SearchKey() {
        Set<String> keys = new HashSet<String>();
        keys = stringRedisTemplate.keys("*");
        out(keys);
        keys = stringRedisTemplate.keys("*String*");
        out(keys);

        RKeys rKeys = redissonClient.getKeys();
        Iterator iterator = rKeys.getKeysByPattern("*").iterator();
        while (iterator.hasNext()) {
            out(iterator.next());
        }
        iterator = rKeys.getKeysByPattern("*String*").iterator();
        while (iterator.hasNext()) {
            out(iterator.next());
        }

    }


    /**
     * 事物处理 redisTemplate.execute--> redissonClient.createTransaction()
     */
    @Test
    public void transaction() {
        RTransaction transaction = redissonClient.createTransaction(TransactionOptions.defaults());
        RBucket<String> bucket = transaction.getBucket("3333");
        bucket.set("3333");
        bucket = transaction.getBucket("5555");
        bucket.set("5555");
        int a = 1 / 0;
        transaction.commit();
        //out(bucket.get());
    }

    @Test
    public void transaction2() {
        redisTemplate.execute(new SessionCallback() {
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.multi();
                redisTemplate.opsForValue().set("1111", "1111");
                redisTemplate.opsForValue().set("2222", "2222");
                int a = 1 / 0;
                return redisOperations.exec();
            }
        });
    }


    /**
     * 分布式锁demo  https://blog.csdn.net/hgdzw/article/details/97241208?utm_medium=distribute.pc_relevant.none-task-blog-title-10&spm=1001.2101.3001.4242
     */
    @Test
    public void Lock() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Set<Callable<String>> futureSet = new HashSet<Callable<String>>();
        for (int i = 0; i < 6; i++) {
            futureSet.add(new Callable<String>() {
                public String call() throws Exception {
                    //创建锁对象，并制定锁名称
                    RLock rLock = redissonClient.getLock("lock-test");
                    // 获取锁并设置失效时间 20*1000ms
                    boolean isGetLock = rLock.tryLock(0, 20000, TimeUnit.MILLISECONDS);
                    //判断是否获取到锁
                    if (!isGetLock) {
                        out("获取锁失败 💔💔");
                        return null;
                    }
                    //todo 执行各种业务
                    try {
                        out("👴👴获取锁成功了😄😄");
                    } catch (Exception e) {
                        out(e.getMessage());
                    } finally {
                        out("释放锁了 👋👋");
                        rLock.unlock();
                    }
                    return null;
                }
            });
        }
        //并发模拟
        executorService.invokeAll(futureSet);
    }

}
