package phong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import phong.model.User;
import phong.model.UserType;
import phong.repo.RepoUser;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    RepoUser repo;

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder().name("name 1").type(UserType.VIP).build();
        repo.save(user);

        user = User.builder().name("name 2").type(UserType.NORMAL).build();
        repo.save(user);
    }
}
