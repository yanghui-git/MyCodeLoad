package com.yh.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * consul Feign Demo
 * https://blog.csdn.net/weixin_42465125/article/details/88395453?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control
 */
@SpringBootApplication
//将自己作为一个可以被Eureka Server发现注册的Client
@EnableDiscoveryClient
// 将自己作为一个可以被其他服务通过Feign调用的Client
@EnableFeignClients
public class ConsulFeignProducer {
    public static void main(String[] args) {
        SpringApplication.run(ConsulFeignProducer.class);
    }
}
