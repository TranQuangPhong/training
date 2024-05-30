package phong.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import phong.redis.service.base.BaseRedisService;

@RestController
@RequestMapping("/redis/v1")
public class RedisController {
    @Autowired
    private BaseRedisService redisService;

    @GetMapping("/dummy")
    public ResponseEntity<Object> dummyGet() {
        return ResponseEntity.ok().body("get dummy");
    }

    @PostMapping("/dummy")
    public ResponseEntity<Object> dummySet(@RequestParam String key, @RequestParam String value) {
        redisService.set(key, value);
        return ResponseEntity.ok().build();
    }
}
