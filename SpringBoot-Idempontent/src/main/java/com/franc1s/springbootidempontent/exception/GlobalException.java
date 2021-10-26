package com.franc1s.springbootidempontent.exception;

import com.franc1s.springbootidempontent.interceptor.IdempotentInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException{
    @ExceptionHandler(IdempotentException.class)
    public String idempotentException(IdempotentException exception){
        return exception.getMessage();
    }
}
