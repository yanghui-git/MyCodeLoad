package com.yh.toredisson.conf;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.SerializationCodec;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置redisson连接
 */
@Configuration
public class RedisSonConfig {

    @Bean
    public RedissonClient getRedisSon() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://10.20.178.137:6379").
                setDatabase(0)
                .setPassword("123456");
        //config.setCodec(new SerializationCodec());
        return Redisson.create(config);
    }

}
