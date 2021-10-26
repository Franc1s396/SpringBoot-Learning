package com.franc1s.springbootehcache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //如果方法存在多个参数,则默认情况下,多个参数共同作为缓存的key
    //也可以自己指定缓存的key
    //@Cacheable(cacheNames = "cache1",key = "#id")
    @Cacheable(cacheNames = "user")
    public User getUserById(Long id) {
        System.out.println(id);
        User user = new User();
        user.setId(id);
        user.setUsername("javaboy");
        return user;
    }

/*    //删除缓存
    @CacheEvict
    public void deleteUserById(Long id){
        System.out.println("delete");
    }

    //更新缓存,若缓存不存在，则进行缓存，否则进行更新.
    @CachePut(key = "#user.id")
    public User updateUserById(User user) {
        return user;
    }*/
}
