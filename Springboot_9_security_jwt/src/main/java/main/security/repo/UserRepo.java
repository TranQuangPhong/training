package main.security.repo;

import main.security.account.CustomUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public CustomUser getUser(String username) {

        if(username.equals("name"))
            return new CustomUser("name", passwordEncoder.encode("password"));
        return null;
    }
}
