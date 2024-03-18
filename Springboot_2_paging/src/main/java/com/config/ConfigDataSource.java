package com.config;

import com.model.User;
import com.repo.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class ConfigDataSource {
    @Autowired
    RepoUser repo;

    @PostConstruct
    public void initData() {
        repo.saveAll(
                IntStream
                        .range(1, 100)
                        .mapToObj(i -> User.builder().name("name " + i).build())
                        .collect(Collectors.toList())
        );
    }
}
