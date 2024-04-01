package phong.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import phong.redis.service.base.BaseRedisService;

@RestController
@RequestMapping("/redis/v1")
public class RedisController {
    @Autowired
    private BaseRedisService redisService;

    @PostMapping("/dummy/set")
    public ResponseEntity<Object> dummySet(@RequestParam String key, @RequestParam String value) {
        redisService.set(key, value);
        return ResponseEntity.ok().build();
    }
}
