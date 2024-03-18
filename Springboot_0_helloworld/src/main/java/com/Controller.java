package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {
    @RequestMapping("/home")
    @ResponseBody
    public User home(){
        return new User();
    }

    @RequestMapping("/user")
    @ResponseBody
    public User example(){
        return new User(1, "abcd");
    }
}
