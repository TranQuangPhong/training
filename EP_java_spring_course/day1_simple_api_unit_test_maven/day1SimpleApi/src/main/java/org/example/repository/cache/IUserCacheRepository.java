package org.example.repository.cache;

import org.example.entity.cache.UserEntityCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserCacheRepository extends CrudRepository<UserEntityCache, Integer> {
}
