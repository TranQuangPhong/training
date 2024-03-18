package org.example.controller;

import org.example.entity.cache.UserEntityCache;
import org.example.service.cache.IUserCacheTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users/template")
public class UserTemplateController {
    @Autowired
    IUserCacheTemplateService userCacheTemplateService;

    @GetMapping("/")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok().body(userCacheTemplateService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok().body(userCacheTemplateService.getUser(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserEntityCache user) {
        return ResponseEntity.ok().body(userCacheTemplateService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserEntityCache user) {
        return ResponseEntity.ok().body(userCacheTemplateService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        return ResponseEntity.ok().body(userCacheTemplateService.deleteUser(id));
    }
}
