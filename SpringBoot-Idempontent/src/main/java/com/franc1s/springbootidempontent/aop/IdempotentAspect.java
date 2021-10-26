package com.franc1s.springbootidempontent.aop;

import com.franc1s.springbootidempontent.exception.IdempotentException;
import com.franc1s.springbootidempontent.token.TokenService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
//@Aspect
public class IdempotentAspect {
    @Autowired
    TokenService tokenService;

    @Pointcut("@annotation(com.franc1s.springbootidempontent.anno.AutoIdempotent)")
    public void pc1(){

    }

    @Before("pc1()")
    public void before() throws IdempotentException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            tokenService.checkToken(request);
        } catch (IdempotentException exception) {
            throw exception;
        }
    }
}
