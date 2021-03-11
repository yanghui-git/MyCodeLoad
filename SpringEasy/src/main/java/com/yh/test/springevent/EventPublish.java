package com.yh.test.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布
 */
@Component
public class EventPublish {

    @Autowired
    private ApplicationContext applicationContext;

    public void publish() {
        EventDao eventDao = new EventDao(applicationContext, "test1", 100, "hangz");
        applicationContext.publishEvent(eventDao);
        System.out.println("发布事件成功");
    }

}
