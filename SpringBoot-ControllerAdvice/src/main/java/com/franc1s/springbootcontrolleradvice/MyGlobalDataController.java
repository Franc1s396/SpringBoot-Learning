package com.franc1s.springbootcontrolleradvice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
public class MyGlobalDataController {

    @GetMapping("/hello")
    public void hello(Model model) {
        Map<String, Object> asMap = model.asMap();
        Map<String, String> info = (Map<String, String>) asMap.get("info");
        Set<String> keySet = info.keySet();
        for (String s : keySet) {
            System.out.println(s+"----"+info.get(s));
        }
    }

    @GetMapping("/hello1")
    public String hello1(){
        return "123";
    }
}
