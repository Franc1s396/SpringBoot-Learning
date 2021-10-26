package com.franc1s.springbootcontrolleradvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyGlobalException1 {

    @ExceptionHandler(Exception.class)
    public ModelAndView customerException(Exception e){
        ModelAndView modelAndView = new ModelAndView("javaboy");
        modelAndView.addObject("error",e.getMessage());
        return modelAndView;
    }
}
