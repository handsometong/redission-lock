package com.tom.demo.lock.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRedissonConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient(){
        // 创建配置  记得加redis://
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        // 根据配置创建RedissClient客户端
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}