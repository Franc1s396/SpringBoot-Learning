package com.franc1s.springbootidempontent.controller;

import com.franc1s.springbootidempontent.anno.AutoIdempotent;
import com.franc1s.springbootidempontent.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    TokenService tokenService;

    @GetMapping("/getToken")
    public String getToken(){
        return tokenService.createToken();
    }

    @PostMapping("/hello")
    @AutoIdempotent
    public String hello(){
        return "hello";
    }

    @PostMapping("/hello2")
    public String hello2(){
        return "hello2";
    }
}
