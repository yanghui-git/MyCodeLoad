package com.yh.test.springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听者
 */
@Component
public class EventConsumer implements ApplicationListener<EventDao> {

    @Override
    public void onApplicationEvent(EventDao eventDao) {
        System.out.println("收到发布事件内容 消费者1" + eventDao.toString());
    }
}
