package com.franc1s.springbootcontrolleradvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyGlobalException {
    @ExceptionHandler(Exception.class)
    public String customerException(Exception e){
        return e.getMessage();
    }
}
