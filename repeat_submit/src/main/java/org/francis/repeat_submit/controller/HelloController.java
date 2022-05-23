package org.francis.repeat_submit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franc1s
 * @date 2022/5/23
 * @apiNote
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestBody String json){
        return json;
    }
}
