package com.jpa;

import com.jpa.model.Address;
import com.jpa.model.Person;
import com.jpa.repo.RepoAddress;
import com.jpa.repo.RepoPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Arrays;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    RepoAddress repoAddress;
    @Autowired
    RepoPerson repoPerson;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Person p1 = Person.builder().name("p1").build();
        Person p2 = Person.builder().name("p2").build();

        Address a1 = Address.builder().city("c1").province("pr1").build();
        Address a2 = Address.builder().city("c2").province("pr2").build();

        a1.setPersons(Arrays.asList(p1, p2));
        a2.setPersons(Arrays.asList(p1));

//        p1.setAddresses(Arrays.asList(a1, a2));
//        p2.setAddresses(Arrays.asList(a1));

        repoAddress.saveAndFlush(a1);
        repoAddress.saveAndFlush(a2);

//        repoPerson.saveAndFlush(p1);
//        repoPerson.saveAndFlush(p2);

    }
}
