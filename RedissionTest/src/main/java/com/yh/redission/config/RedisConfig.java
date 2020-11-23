package com.yh.redission.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * 配置redisson连接
 */
@Service
public class RedisConfig {

    @Bean
    public RedissonClient getRedis() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://10.20.178.137:6379").
                setDatabase(0)
                .setPassword("123456");
        return Redisson.create(config);
    }
}
