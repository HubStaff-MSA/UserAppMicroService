package com.roba.security.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TokenService {

    @Autowired
    private RedisTemplate<String, Token> redisTemplate;

    // Save or update token in Redis and cache
    @CachePut(value = "tokens", key = "#token.id")
    public Token saveToken(Token token) {
        redisTemplate.opsForValue().set(buildRedisKey(token.getId()), token, 30, TimeUnit.MINUTES);
        return token;
    }

    // Retrieve token from cache or Redis
    @Cacheable(value = "tokens", key = "#id")
    public Token getToken(Integer id) {
        // This will only execute if the token is not found in the cache
        return redisTemplate.opsForValue().get(buildRedisKey(id));
    }

    // Remove token from Redis and cache
    @CacheEvict(value = "tokens", key = "#id")
    public void deleteToken(Integer id) {
        redisTemplate.delete(buildRedisKey(id));
    }

    private String buildRedisKey(Integer id) {
        return "TOKEN_" + id;
    }
}
