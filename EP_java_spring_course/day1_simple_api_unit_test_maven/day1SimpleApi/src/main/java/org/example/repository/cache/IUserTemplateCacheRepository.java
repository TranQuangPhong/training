package org.example.repository.cache;

import org.example.entity.cache.UserEntityCache;

import java.util.Map;

public interface IUserTemplateCacheRepository {
    Map<Integer, UserEntityCache> getUsers();

    UserEntityCache createUser(UserEntityCache user);

    UserEntityCache getUser(Integer id);

    UserEntityCache updateUser(Integer id, UserEntityCache user);

    Boolean deleteUser(Integer id);
}
