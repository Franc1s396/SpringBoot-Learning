package org.francis.dd.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.francis.dd.datasource.DataSourceType;
import org.francis.dd.datasource.DynamicDataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author Franc1s
 * @date 2022/5/15
 * @apiNote
 */
@Aspect
@Component
@Order(11)
public class GlobalDataSourceAspect {

    @Autowired
    private HttpSession session;

    @Pointcut("execution(* org.francis.dd.service.*.*(..))")
    public void pc() {

    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint) {
        DynamicDataSourceContextHolder.setDataSourceType((String) session.getAttribute(DataSourceType.DS_SESSION_KEY));
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
        return null;
    }
}
