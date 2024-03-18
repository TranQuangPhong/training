package com.auth.repo;

import com.auth.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<CustomUser, Long> {

    List<CustomUser> findByUsername(String s);
}
