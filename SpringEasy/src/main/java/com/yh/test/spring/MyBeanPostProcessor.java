package com.yh.test.spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.InitBinder;

@Configuration
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MyBeanPostProcessor implements InitializingBean {

    private String name;

    private Integer age;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init...... MyBeanPostProcessor....  ");
    }

}
