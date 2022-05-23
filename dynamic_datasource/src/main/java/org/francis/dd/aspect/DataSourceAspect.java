package org.francis.dd.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.francis.dd.annotation.DataSource;
import org.francis.dd.datasource.DynamicDataSourceContextHolder;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Franc1s
 * @date 2022/5/15
 * @apiNote
 */
@Component
@Aspect
@Order(10)
public class DataSourceAspect {

    /**
     * @annotation(org.francis.dd.annotation.DataSource) 表示方法上有这个注解就拦截下来
     * @within(org.francis.dd.annotation.DataSource) 表示类上有这个注解就将这个类中的方法拦截下来
     */
    @Pointcut("@annotation(org.francis.dd.annotation.DataSource) || @within(org.francis.dd.annotation.DataSource)")
    public void pc() {

    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint joinPoint) {
        DataSource dataSource = getDataSource(joinPoint);
        if (dataSource!=null) {
            String dataSourceType = dataSource.value();
            DynamicDataSourceContextHolder.setDataSourceType(dataSourceType);
        }
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
        return null;
    }

    private DataSource getDataSource(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DataSource dataSource = AnnotationUtils.findAnnotation(methodSignature.getMethod(), DataSource.class);
        if (dataSource != null) {
            return dataSource;
        }
        return AnnotationUtils.findAnnotation(methodSignature.getDeclaringType(),DataSource.class);
    }
}
