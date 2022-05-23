package org.francis.rate_limiter.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.francis.rate_limiter.annotation.RateLimiter;
import org.francis.rate_limiter.enums.LimitType;
import org.francis.rate_limiter.exception.RateLimitException;
import org.francis.rate_limiter.utils.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Collections;

/**
 * @author Franc1s
 * @date 2022/5/23
 * @apiNote
 */
@Aspect
@Component
public class RateLimiterAspect {
    private static final Logger log = LoggerFactory.getLogger(RateLimiterAspect.class);
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    RedisScript<Long> redisScript;

    @Before("@annotation(rateLimiter)")
    public void before(JoinPoint jp, RateLimiter rateLimiter) throws RateLimitException {
        int time = rateLimiter.time();
        int count = rateLimiter.count();
        String combineKey = getCombineKey(rateLimiter, jp);
        try {
            Long result = redisTemplate.execute(redisScript, Collections.singletonList(combineKey), time, count);
            if (result == null || result.intValue() > count) {
                //超过限流
                log.info("当前接口已达到最大限流次数");
                throw new RateLimitException("访问过于频繁，请稍后访问");
            }
            log.info("一个时间窗内请求次数:{},当前请求次数:{},缓存的key为{}", count, result, combineKey);
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * 这个key就是接口调用次数缓存在redis上的key
     *
     * @param rateLimiter
     * @param jp
     * @return
     */
    private String getCombineKey(RateLimiter rateLimiter, JoinPoint jp) {
        StringBuffer key = new StringBuffer(rateLimiter.key());
        if (rateLimiter.limitType() == LimitType.IP) {
            key.append(IpUtils.getIpAddr(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest())).append("-");
        }
        MethodSignature signature = (MethodSignature) jp.getSignature();
        Method method = signature.getMethod();
        key.append(method.getDeclaringClass().getName())
                .append("-")
                .append(method.getName());
        return key.toString();
    }
}

