package com.yh.test.dependson;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class DependsOnTest {

    @Bean
    @DependsOn("dependTestTwo")
    public DependTestOne getDependTestOne(){
        System.out.println("DependTestOne..........");
        return new DependTestOne();
    }

    @Bean(name = "dependTestTwo")
    public DependTestTwo getDependTestTwo() throws InterruptedException {
        Thread.sleep(3000l);
        System.out.println("DependTestTwo");
        return new DependTestTwo();
    }

    @Bean
    @ConditionalOnProperty(name = "ConditionalOnProperty",havingValue = "123")
    public ConditionalOnPropertTest getConditionalOnPropert(){
        System.out.println("6666666666");
        return null;
    }



}
