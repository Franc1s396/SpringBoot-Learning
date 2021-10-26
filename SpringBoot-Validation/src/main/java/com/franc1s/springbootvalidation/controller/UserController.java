package com.franc1s.springbootvalidation.controller;

import com.franc1s.springbootvalidation.model.User;
import com.franc1s.springbootvalidation.validation.ValidationGroup1;
import com.franc1s.springbootvalidation.validation.ValidationGroup2;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @PostMapping("/addUser")
    public void addUser(@Validated(value = {ValidationGroup1.class, ValidationGroup2.class}) User user, BindingResult result) {
        if (result != null && result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println(allError.getObjectName() + " " + allError.getDefaultMessage());
            }
        }
    }
}
