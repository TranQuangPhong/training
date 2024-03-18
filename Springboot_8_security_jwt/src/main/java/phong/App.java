package phong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import phong.auth.account.Account;
import phong.auth.jwt.JwtTokenProvider;
import phong.auth.repository.AccountRepository;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    AccountRepository repo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Account account = new Account();
        account.setUsername("admin");
        account.setPassword(passwordEncoder.encode("password"));

        repo.save(account);
        System.out.println(account);
    }
}
