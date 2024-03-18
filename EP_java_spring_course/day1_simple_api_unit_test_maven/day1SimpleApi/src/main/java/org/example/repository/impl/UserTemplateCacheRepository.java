package org.example.repository.impl;

import org.example.entity.cache.UserEntityCache;
import org.example.repository.cache.IUserTemplateCacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserTemplateCacheRepository implements IUserTemplateCacheRepository {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    private final String HASH_KEY = "users-movies-template";

    private final HashOperations<Object, Integer, UserEntityCache> hashOperations;

    @Autowired
    public UserTemplateCacheRepository(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<Integer, UserEntityCache> getUsers() {
        return hashOperations.entries(HASH_KEY);
    }

    @Override
    public UserEntityCache createUser(UserEntityCache user) {
        if (Boolean.TRUE.equals(hashOperations.putIfAbsent(HASH_KEY, user.getId(), user)))
            return user;
        return null;
    }

    @Override
    public UserEntityCache getUser(Integer id) {
        return hashOperations.get(HASH_KEY, id);
    }

    @Override
    public UserEntityCache updateUser(Integer id, UserEntityCache user) {
        if (Boolean.TRUE.equals(hashOperations.hasKey(HASH_KEY, id))) {
            hashOperations.put(HASH_KEY, id, user);
            return user;
        }
        return null;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        hashOperations.delete(HASH_KEY, id);
        return true;
    }

}
