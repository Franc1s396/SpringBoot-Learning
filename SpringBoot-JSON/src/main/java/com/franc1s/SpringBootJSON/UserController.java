package com.franc1s.SpringBootJSON;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.franc1s.SpringBootJSON.User;

@RestController
public class UserController {
    @GetMapping("/user")
    public User getUser(){
        User user=new User();
        return user;
    }
}
