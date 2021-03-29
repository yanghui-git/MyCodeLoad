package com.yh.test.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件监听者
 */
@Component
@Async
public class EventConsumerTwo implements ApplicationListener<EventDao> {

    @Override
    public void onApplicationEvent(EventDao eventDao) {
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
        System.out.println("收到发布事件内容 消费者2" + eventDao.toString());
    }
}
