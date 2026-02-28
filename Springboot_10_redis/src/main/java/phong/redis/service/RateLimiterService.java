package phong.redis.service;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Service;
import phong.redis.service.base.impl.BaseRedisServiceImpl;

import java.time.Instant;
import java.util.List;

@Service
public class RateLimiterService extends BaseRedisServiceImpl {

    public RateLimiterService(RedisTemplate<String, Object> redisTemplate) {
        super(redisTemplate);
    }

    /**
     * Sliding window rate limiter
     *
     * @param key                     unique key - e.g. user, token, ip address...
     * @param quota                   maximum number of requests in a window time
     * @param windowSizeInMilliSecond window size in millisecond
     * @return true of quota exceeds - return HTTP 429
     */
    public boolean isRequestQuotaExceed(String key, int quota, long windowSizeInMilliSecond) {

        System.out.println(this.getClass() + ":isRequestQuotaExceed()");
        List<Object> txResults = redisTemplate.execute(new SessionCallback<>() {
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                try {
                    long now = Instant.now().toEpochMilli();
                    long windowStart = now - windowSizeInMilliSecond;

                    //Start redis transaction
                    operations.multi();

                    //Remove old requests outside of window
                    operations.opsForZSet().removeRangeByScore(key, 0, windowStart);

                    //Count requests inside window
                    operations.opsForZSet().count(key, windowStart, now);

                    //Add new request
                    operations.opsForZSet().add(key, String.valueOf(now), now);

                    return operations.exec();
                } catch (RuntimeException e) {
                    operations.discard();
                    throw e;
                }
            }
        });

        System.out.println("Requests quota: " + quota);
        System.out.println("Window size in millisecond: " + windowSizeInMilliSecond);

        //Execute transaction and get count value from returned result
        assert txResults != null;
        Long requestsCount = (Long) txResults.get(1);
        System.out.println("Current numbers of requests: " + requestsCount);

        return requestsCount != null && requestsCount >= quota;
    }
}
