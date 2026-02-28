package phong.redis.service.base.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import phong.redis.service.base.BaseRedisService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@Primary
public class BaseRedisServiceImpl implements BaseRedisService {

    protected RedisTemplate<String, Object> redisTemplate;
    protected HashOperations<String, String, Object> hashOperations;

    public BaseRedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setTtl(String key, long ttl, TimeUnit timeUnit) {
        redisTemplate.expire(key, ttl, timeUnit);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean isKeyExist(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    @Override
    public void hashSet(String key, String field, String value) {
        hashOperations.put(key, field, value);
    }

    @Override
    public Object hashGet(String key, String field) {
        return hashOperations.get(key, field);
    }

    @Override
    public boolean isHashExist(String key, String field) {
        return hashOperations.hasKey(key, field);
    }

    @Override
    public Set<String> getFieldKeys(String key) {
        return hashOperations.entries(key).keySet();
    }

    @Override
    public Map<String, Object> hashGetFields(String key) {
        return hashOperations.entries(key);
    }

    @Override
    public List<Object> hashGetByFieldsPrefix(String key, String fieldPrefix) {

        return hashOperations.entries(key)
                .entrySet().stream().filter(field -> field.getKey().startsWith(fieldPrefix))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void delete(String key, String field) {
        hashOperations.delete(key, field);
    }

    @Override
    public void delete(String key, List<String> fields) {
        hashOperations.delete(key, fields.toArray());
    }
}
