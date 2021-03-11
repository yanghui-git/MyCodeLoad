package com.yh.test.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听者
 */
@Component
public class EventConsumerTwo implements ApplicationListener<EventDao> {

    @Override
    public void onApplicationEvent(EventDao eventDao) {
        System.out.println("收到发布事件内容 消费者2" + eventDao.toString());
    }
}
