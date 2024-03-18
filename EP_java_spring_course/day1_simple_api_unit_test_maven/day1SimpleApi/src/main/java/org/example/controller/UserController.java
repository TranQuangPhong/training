package org.example.controller;

import org.example.entity.cache.UserEntityCache;
import org.example.service.cache.IUserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    IUserCacheService userCacheService;

    @GetMapping("/")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(userCacheService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userCacheService.getUser(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserEntityCache user) {
        return ResponseEntity.ok().body(userCacheService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserEntityCache user) {
        return ResponseEntity.ok().body(userCacheService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        return ResponseEntity.ok().body(userCacheService.deleteUser(id));
    }
}
