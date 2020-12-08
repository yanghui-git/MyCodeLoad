package com.yh.toredisson.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RTopicDemo {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void test() {
        RTopic rTopic = redissonClient.getTopic("redis-topic");
        //   rTopic.addListener(String.class, new MessageListener<String>() {
        //         public void onMessage(CharSequence charSequence, String s) {
        //              System.out.println(s);
        //         }
        //     });
        rTopic.addListener(String.class, new MessageListenerDemo());
        //
        while (true) {
            try {
                Thread.sleep(5 * 1000l);
                rTopic.publish("haha" + new Date());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
