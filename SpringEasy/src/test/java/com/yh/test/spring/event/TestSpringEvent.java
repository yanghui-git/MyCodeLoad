package com.yh.test.spring.event;

import com.yh.test.springevent.EventPublish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSpringEvent {

    @Autowired
    private EventPublish eventPublish;

    @Test
    public void test1() {
        eventPublish.publish();
    }


}
