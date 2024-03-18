package org.example.service.cache.impl;

import org.example.entity.cache.UserEntityCache;
import org.example.repository.cache.IUserCacheRepository;
import org.example.service.cache.IUserCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCacheService implements IUserCacheService {
    @Autowired
    IUserCacheRepository userCacheRepository;

    @Override
    public Iterable<UserEntityCache> getUsers() {
        return userCacheRepository.findAll();
    }

    @Override
    public UserEntityCache createUser(UserEntityCache user) {
        return userCacheRepository.save(user);
    }

    @Override
    public UserEntityCache getUser(Integer id) {
        Optional<UserEntityCache> optionalUser = userCacheRepository.findById(id);
        if (optionalUser.isEmpty())
            return null;
        return optionalUser.get();
    }

    @Override
    public UserEntityCache updateUser(Integer id, UserEntityCache user) {
        return userCacheRepository.save(user);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        userCacheRepository.deleteById(id);
        return true;
    }
}
