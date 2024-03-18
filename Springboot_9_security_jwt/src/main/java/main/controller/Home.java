package main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class Home {

    @GetMapping
    public String home(){
        return "home page";
    }

    @GetMapping("login")
    public String login(){
        return "login page";
    }
}
