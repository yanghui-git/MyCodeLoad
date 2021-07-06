package com.yh.test.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyBeanTest {

    @Bean
    public MyBean getMyBean() {
        return MyBean.builder().id(1).name("bean test").build();
    }
}
