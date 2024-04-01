package phong.redis.service.base;


import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import phong.redis.configuration.TestAppConfiguration;
import phong.redis.configuration.TestRedisConfiguration;
import phong.redis.service.base.impl.BaseRedisServiceImpl;

import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
//Use this to run intergration
//@SpringBootTest
//Use this to limit test scope
@ContextConfiguration(classes = {TestAppConfiguration.class, TestRedisConfiguration.class})
public class BaseRedisServiceImplTest {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    BaseRedisService baseRedisService;

    String key = "key";
    String value = "value";

    String hashKey = "hashKey";
    String hashField = "hashField";
    String hashValue = "hashValue";
    String hashField2 = "hashField2";
    String hashValue2 = "hashValue2";

    @Before
    public void setup() {
        baseRedisService = new BaseRedisServiceImpl(redisTemplate);
    }

    @Test
    public void set_and_get_successfully_test() {
        baseRedisService.set(key, value);
        String expect = (String) baseRedisService.get(key);
        Assert.assertEquals(expect, value);
    }

    @Test
    public void isKeyExist_test() {
        baseRedisService.set(key, value);
        Boolean result = baseRedisService.isKeyExist(key);
        Assert.assertEquals(true, result);
    }

    @Test
    public void setTtl_successfully_test() {
        baseRedisService.set(key, value);
        long expireTime = 5L;
        baseRedisService.setTtl(key, expireTime, TimeUnit.SECONDS);

        Long result = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        MatcherAssert.assertThat("Expire time must be lower than {expireTime} and greater than 0",
                0 < result && result < expireTime);

        try {
            Thread.sleep(expireTime * 1000);
            result = redisTemplate.getExpire(key, TimeUnit.SECONDS);
            MatcherAssert.assertThat("Key expired! Expire time must be negative number", result < 0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void hashSet_hashSet_successfully_test() {
        baseRedisService.hashSet(hashKey, hashField, hashValue);
        Object result = baseRedisService.hashGet(hashKey, hashField);
        Assert.assertEquals(result, hashValue);
    }

    @Test
    public void hashExist_test() {
        baseRedisService.hashSet(hashKey, hashField, hashValue);
        boolean result = baseRedisService.isHashExist(hashKey, hashField);
        Assert.assertTrue(result);
    }

    @Test
    public void getFieldKeys_successfully_test() {
        Set<String> expect = new HashSet<>();
        expect.add(hashField);
        expect.add(hashField2);

        baseRedisService.hashSet(hashKey, hashField, hashValue);
        baseRedisService.hashSet(hashKey, hashField2, hashValue2);
        Set<String> result = baseRedisService.getFieldKeys(hashKey);

        Assert.assertEquals(expect, result);
    }

    @Test
    public void hashGetFields_successfully_test() {
        Map<String, Object> expect = new HashMap<>();
        expect.put(hashField, hashValue);
        expect.put(hashField2, hashValue2);

        Map<String, Object> result = baseRedisService.hashGetFields(hashKey);
        Assert.assertEquals(expect, result);
    }

    @Test
    public void hashGetByFieldsPrefix_successfully_test() {
        List<Object> expect = new ArrayList<>();
        expect.add(hashValue);
        expect.add(hashValue2);

        List<Object> result = baseRedisService.hashGetByFieldsPrefix(hashKey, "hashF");
        MatcherAssert.assertThat("Same lists", expect.containsAll(result));
    }

    @Test
    public void delete_key_successfully_test() {
        baseRedisService.set(key, value);
        Assert.assertTrue(baseRedisService.isKeyExist(key));
        baseRedisService.delete(key);
        Assert.assertFalse(baseRedisService.isKeyExist(key));
    }

    @Test
    public void delete_key_field_successfully_test() {
        baseRedisService.hashSet(hashKey, hashField, hashValue);
        Assert.assertTrue(baseRedisService.isHashExist(hashKey, hashField));
        baseRedisService.delete(hashKey, hashField);
        Assert.assertFalse(baseRedisService.isHashExist(hashKey, hashField));
    }

    @Test
    public void delete_key_and_listOfFields_successfully_test() {
        List<String> fields = new ArrayList<>();
        fields.add(hashField);
        fields.add(hashField2);

        baseRedisService.hashSet(hashKey, hashField, hashValue);
        baseRedisService.hashSet(hashKey, hashField2, hashValue2);
        Assert.assertTrue(baseRedisService.isHashExist(hashKey, hashField));
        Assert.assertTrue(baseRedisService.isHashExist(hashKey, hashField2));

        baseRedisService.delete(hashKey, fields);
        Assert.assertFalse(baseRedisService.isHashExist(hashKey, hashField));
        Assert.assertFalse(baseRedisService.isHashExist(hashKey, hashField2));
    }
}
