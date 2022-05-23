package com.franc1s.springbootidempontent.token;

import com.franc1s.springbootidempontent.exception.IdempotentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class TokenService {
    @Autowired
    RedisService redisService;

    public String createToken(){
        String uuid = UUID.randomUUID().toString();
        redisService.setEx(uuid,uuid, 10000L);
        return uuid;
    }

    public boolean checkToken(HttpServletRequest request) throws IdempotentException {
        String token = request.getHeader("token");
        if (StringUtils.hasText(token)){
            token=request.getParameter("token");
            if (StringUtils.hasText(token)){
                throw new IdempotentException("token不存在");
            }
        }
        if (!redisService.exists(token)){
            throw new IdempotentException("重复操作");
        }
        boolean remove = redisService.remove(token);
        if (!remove){
            throw new IdempotentException("重复操作");
        }
        return true;
    }
}
