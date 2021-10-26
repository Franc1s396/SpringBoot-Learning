package com.franc1s.springbootcors1;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(value = "http://localhost:8081",maxAge = 1800)
public class HelloController {


    //@CrossOrigin("http://localhost:8081")
    @GetMapping("/hello")
    public String hello(){
        return "123";
    }

    @PutMapping("/hello1")
    public String hello1(){
        return "hello put";
    }
}
