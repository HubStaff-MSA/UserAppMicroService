package com.roba.security.token;



import com.roba.security.user.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("redis-12006.c62.us-east-1-4.ec2.redns.redis-cloud.com");
        factory.setPort(12006);
        factory.setPassword("oSrE2KvyJdxFJ8vmpDlIBDtQ9ZriadjR");
        return factory;
    }

    @Bean
    public RedisTemplate<String, Token> redisTemplateToken() {
        RedisTemplate<String, Token> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;

    }
    @Bean
    public RedisTemplate<String, User> redisTemplate() {
        RedisTemplate<String, User> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

}