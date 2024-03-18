package com.auth.service;

import com.auth.model.CustomUserDetails;
import com.auth.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return new CustomUserDetails(new User(1L, "user", passwordEncoder.encode("password")));
        return new CustomUserDetails(repo.findByUsername(s).get(0));
    }
}
