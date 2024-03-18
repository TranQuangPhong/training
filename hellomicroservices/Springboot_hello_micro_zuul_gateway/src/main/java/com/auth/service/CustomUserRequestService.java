package com.auth.service;

import com.auth.model.CustomUser;
import com.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserRequestService {
    @Autowired
    UserRepo repo;

    public CustomUser saveUser(CustomUser customUser) {
        return repo.save(customUser);
    }
}
