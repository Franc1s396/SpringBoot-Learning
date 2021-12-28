package org.francis.springbootspringbatch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
@RestController
public class TestController {
    @GetMapping("/executeBatch")
    public String executeBatch(){
        return null;
    }
}
