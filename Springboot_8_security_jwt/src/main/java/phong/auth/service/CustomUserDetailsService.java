package phong.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import phong.auth.account.Account;
import phong.auth.account.CustomUserDetails;
import phong.auth.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AccountRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repo.findByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(account);
    }

    public UserDetails loadUserByUserId(Long id){
        Account account = repo.getById(id);
        if(account == null) {
            throw new UsernameNotFoundException("User id: " + Long.toString(id));
        }
        return new CustomUserDetails(account);
    }
}
