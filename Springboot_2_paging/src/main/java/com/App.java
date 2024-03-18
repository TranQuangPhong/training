package com;

import com.model.User;
import com.repo.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    RepoUser repo;

    @Override
    public void run(String... args) throws Exception {

        Page<User> page = repo.findAll(PageRequest.of(0, 5, Sort.by("name").ascending()));
        System.out.println("5 phan tu dau tien");
        page.forEach(System.out::println);

        page = repo.findAll(page.nextPageable());
        System.out.println("5 phan tu tiep theo");
        page.forEach(System.out::println);

        System.out.println("In ra số lượng user ở page hiện tại: " + page.getSize());
        System.out.println("In ra tổng số lượng user: " + page.getTotalElements());
        System.out.println("In ra tổng số page: " + page.getTotalPages());

        List<User> userList = repo.findAllByNameLike("%2", PageRequest.of(0, 5));
        userList.forEach(System.out::println);
    }
}
