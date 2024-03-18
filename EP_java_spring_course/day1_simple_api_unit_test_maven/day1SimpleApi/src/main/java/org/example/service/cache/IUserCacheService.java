package org.example.service.cache;

import org.example.entity.cache.UserEntityCache;

public interface IUserCacheService {
    Iterable<UserEntityCache> getUsers();

    UserEntityCache createUser(UserEntityCache user);

    UserEntityCache getUser(Integer id);

    UserEntityCache updateUser(Integer id, UserEntityCache user);

    Boolean deleteUser(Integer id);
}
