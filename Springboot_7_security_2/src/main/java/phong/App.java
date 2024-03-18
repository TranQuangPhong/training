package phong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import phong.auth.AuthUser;
import phong.auth.AuthUserRepository;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    AuthUserRepository repo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        AuthUser authUser = new AuthUser();
        authUser.setUsername("admin");
        authUser.setPassword(passwordEncoder.encode("password"));

        repo.save(authUser);
        System.out.println(authUser);
    }
}
