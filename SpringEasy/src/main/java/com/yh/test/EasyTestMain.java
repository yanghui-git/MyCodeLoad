package com.yh.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
/**
 * 主要是做一些简单的随手demo测试
 */

/**
 *  https://www.cnblogs.com/xuzhujack/p/11322439.html
 */
@EnableAsync
public class EasyTestMain {
    public static void main(String[] args) {
        SpringApplication.run(EasyTestMain.class);
    }
}
