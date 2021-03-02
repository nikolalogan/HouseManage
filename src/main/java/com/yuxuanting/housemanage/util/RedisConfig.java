package com.yuxuanting.housemanage.util;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @author: yuxuanting
 * @description: redis配置类
 * @date: 2021-02-22 10:32
 */
@Configuration
public class RedisConfig {

/*
    @Bean
    @ConditionalOnMissingBean
    public JacksonRedisTemplate jacksonRedisTemplate(LettuceConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        JacksonRedisTemplate template = new JacksonRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }*/

    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

}