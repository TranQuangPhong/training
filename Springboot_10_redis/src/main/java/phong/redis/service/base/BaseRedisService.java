package phong.redis.service.base;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface BaseRedisService {

    void set(String key, String value);

    Object get(String key);

    void setTtl(String key, long ttl, TimeUnit timeUnit);

    boolean isKeyExist(String key);

    void hashSet(String key, String field, String value);

    Object hashGet(String key, String field);

    boolean isHashExist(String key, String field);

    Set<String> getFieldKeys(String key);

    Map<String, Object> hashGetFields(String key);

    List<Object> hashGetByFieldsPrefix(String key, String fieldPrefix);

    void delete(String key);

    void delete(String key, String field);

    void delete(String key, List<String> fields);
}
