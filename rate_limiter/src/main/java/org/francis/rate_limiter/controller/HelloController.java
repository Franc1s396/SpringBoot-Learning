package org.francis.rate_limiter.controller;

import org.francis.rate_limiter.annotation.RateLimiter;
import org.francis.rate_limiter.enums.LimitType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franc1s
 * @date 2022/5/23
 * @apiNote
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    @RateLimiter(time = 10,count = 3,limitType = LimitType.IP)
    public String hello(){
        return "hello";
    }
}
