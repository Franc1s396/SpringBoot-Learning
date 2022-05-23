package org.francis.rate_limiter.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Franc1s
 * @date 2022/5/23
 * @apiNote
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(RateLimitException.class)
    public Map<String, Object> rateLimitException(RateLimitException e){
        Map<String, Object> map = new HashMap<>();
        map.put("status",500);
        map.put("message",e.getMessage());
        return map;
    }
}
