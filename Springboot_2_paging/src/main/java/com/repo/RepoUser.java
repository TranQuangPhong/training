package com.repo;

import com.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoUser extends JpaRepository<User, Long> {

    List<User> findAllByNameLike(String name, Pageable pageable);
}
