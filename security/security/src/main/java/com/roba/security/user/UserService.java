//package com.roba.security.user;
//
//import com.roba.security.token.Token;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//
//
//
//
//import java.util.concurrent.TimeUnit;
//
//
//@Service
//public class UserService {
//
//    @Autowired
//    private RedisTemplate<String, User> redisTemplate;
//
//    // Save or update token in Redis and cache
//    @CachePut(value = "users", key = "#user.id")
//    public User saveUser(User user) {
//        redisTemplate.opsForValue().set(buildRedisKey(user.getId()), user, 30, TimeUnit.MINUTES);
//        return user;
//    }
//
//    // Retrieve token from cache or Redis
//    @Cacheable(value = "users", key = "#id")
//    public User getUser(Integer id) {
//        // This will only execute if the token is not found in the cache
//        return redisTemplate.opsForValue().get(buildRedisKey(id));
//    }
//
////    // Remove token from Redis and cache
////    @CacheEvict(value = "users", key = "#id")
////    public void deleteUser(Integer id) {
////        redisTemplate.delete(buildRedisKey(id));
////    }
//
//    private String buildRedisKey(Integer id) {
//        return "User" + id;
//    }
//}