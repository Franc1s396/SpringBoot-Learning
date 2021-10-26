package com.franc1s.springbootidempontent.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public boolean setEx(String key,String value,Long expireTime){
        boolean result=false;
        try {
            ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
            forValue.set(key,value);
            stringRedisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean exists(String key){
        return stringRedisTemplate.hasKey(key);
    }
    public boolean remove(String key){
        if (exists(key)){
            return stringRedisTemplate.delete(key);
        }
        return false;
    }
}
