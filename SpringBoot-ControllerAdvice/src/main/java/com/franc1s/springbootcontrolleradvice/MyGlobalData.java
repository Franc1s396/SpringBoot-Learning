package com.franc1s.springbootcontrolleradvice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyGlobalData {

    @ModelAttribute("info")
    public Map<String,String> mydata(){
        Map<String,String> info=new HashMap<>();
        info.put("username","javaboy");
        info.put("address","www.javaboy.org");
        return info;
    }

    @InitBinder("b")
    public void b(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("b.");
    }

    @InitBinder("a")
    public void a(WebDataBinder webDataBinder){
        webDataBinder.setFieldDefaultPrefix("a.");
    }
}
