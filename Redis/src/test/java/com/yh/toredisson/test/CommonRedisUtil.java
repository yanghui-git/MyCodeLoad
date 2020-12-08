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
  /*      keys = stringRedisTemplate.keys("*");
        out(keys);
        keys = stringRedisTemplate.keys("*String*");
        out(keys);*/

        RKeys rKeys = redissonClient.getKeys();
        Iterator iterator = rKeys.getKeysByPattern("*").iterator();
        //   while (iterator.hasNext()) {
        // out(iterator.next());
        //   }
        iterator = rKeys.getKeysByPattern("trans*").iterator();
        while (iterator.hasNext()) {
            out(iterator.next());
        }
    }

    /**
     * 过期时间
     */
    @Test
    public void expire() {

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
        //int a = 1 / 0;
        transaction.commit();

        out(redissonClient.getBucket("3333").get());
        out(redissonClient.getBucket("5555").get());
        out(bucket.get());
        // out(transaction.getBucket("3333"));
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

    @Test
    public void batch() {
        RBatch batch = redissonClient.createBatch(BatchOptions.defaults());
        batch.getBucket("batch3").setAsync("batch3");
        batch.getBucket("batch2").setAsync("batch2");
        RBucket rBucket = (RBucket) batch.getBucket("batch4");
        rBucket.set("4444");
        // int a=1/0;
        batch.execute();

        out(batch.getBucket("batch3").getAsync());
        out(redissonClient.getBucket("batch2").get());
        out(batch.getBucket("batch3"));
        out(rBucket.get());
       /* RTransaction transaction = redissonClient.createTransaction(TransactionOptions.defaults());
        RBucket<String> bucket = transaction.getBucket("3333");
        bucket.set("3333");
        bucket = transaction.getBucket("5555");
        bucket.set("5555");

        int a = 1 / 0;
        transaction.commit();
        out(bucket.get());*/
    }

    /**
     * 分布式锁demo  https://blog.csdn.net/hgdzw/article/details/97241208?utm_medium=distribute.pc_relevant.none-task-blog-title-10&spm=1001.2101.3001.4242
     */
    @Test
    public void Lock() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Set<Callable<String>> futureSet = new HashSet<Callable<String>>();
        for (int i = 0; i < 10; i++) {
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

    @Test
    public void Lock2() throws Exception {
        RLock rLock = redissonClient.getLock("lock-test");
        // 获取锁并设置失效时间 20*1000ms
        boolean isGetLock = rLock.tryLock(0, 20000, TimeUnit.MILLISECONDS);
        //判断是否获取到锁
        if (!isGetLock) {
            out("获取锁失败 💔💔");
            return;
        }
        out("分布式锁获取成功");
        out("准备释放分布式锁");
        rLock.unlock();
        //重复释放锁会报错
        //   rLock.unlock();

    }

    /**
     * 删除key
     */
    @Test
    public void deleteKey() {
        redisTemplate.opsForValue().set("4444test", "4444test");
        redisTemplate.opsForValue().set("5555test", "5555test");
        out(redisTemplate.opsForValue().get("4444test"));
        out(redisTemplate.opsForValue().get("5555test"));
        // redisTemplate.delete("4444test");
        redisTemplate.delete("5555test");
        out(redisTemplate.opsForValue().get("4444test"));
        out(redisTemplate.opsForValue().get("5555test"));
        out("66666");
        //
        redissonClient.getBucket("11test").set("11test");
        redissonClient.getBucket("22test").set("22test");
        out(redissonClient.getBucket("11test").get());
        out(redissonClient.getBucket("22test").get());
        redissonClient.getKeys().delete("11test");
        //   redissonClient.getKeys().delete("22test");
        out(redissonClient.getBucket("11test").get());
        out(redissonClient.getBucket("22test").get());
    }
}
