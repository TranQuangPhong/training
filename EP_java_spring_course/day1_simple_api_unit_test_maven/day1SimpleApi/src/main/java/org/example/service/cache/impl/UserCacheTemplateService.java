package org.example.service.cache.impl;

import org.example.entity.cache.UserEntityCache;
import org.example.repository.cache.IUserTemplateCacheRepository;
import org.example.service.cache.IUserCacheTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserCacheTemplateService implements IUserCacheTemplateService {

    @Autowired
    IUserTemplateCacheRepository userTemplateCacheRepository;

    @Override
    public Map<Integer, UserEntityCache> getUsers() {
        return userTemplateCacheRepository.getUsers();
    }

    @Override
    public UserEntityCache createUser(UserEntityCache user) {
        return userTemplateCacheRepository.createUser(user);
    }

    @Override
    public UserEntityCache getUser(Integer id) {
        return userTemplateCacheRepository.getUser(id);
    }

    @Override
    public UserEntityCache updateUser(Integer id, UserEntityCache user) {
        return userTemplateCacheRepository.updateUser(id, user);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        return userTemplateCacheRepository.deleteUser(id);
    }
}
