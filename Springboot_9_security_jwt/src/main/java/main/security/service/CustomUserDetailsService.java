package main.security.service;

import main.security.account.CustomUser;
import main.security.account.CustomUserDetails;
import main.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = repo.getUser(username);
        if(user == null)
            throw  new UsernameNotFoundException(username);
        return new CustomUserDetails(user);
    }
}
