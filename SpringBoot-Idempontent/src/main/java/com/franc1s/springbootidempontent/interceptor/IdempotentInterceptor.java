package com.franc1s.springbootidempontent.interceptor;

import com.franc1s.springbootidempontent.anno.AutoIdempotent;
import com.franc1s.springbootidempontent.exception.IdempotentException;
import com.franc1s.springbootidempontent.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class IdempotentInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenService tokenService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        Method method = ((HandlerMethod) handler).getMethod();
        AutoIdempotent annotation = method.getAnnotation(AutoIdempotent.class);
        if (annotation!=null){
            try {
                return tokenService.checkToken(request);
            } catch (IdempotentException e) {
                throw e;
            }
        }
        return true;
    }
}
