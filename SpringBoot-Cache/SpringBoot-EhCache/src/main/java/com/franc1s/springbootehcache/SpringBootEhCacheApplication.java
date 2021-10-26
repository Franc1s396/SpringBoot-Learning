package com.franc1s.springbootehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootEhCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEhCacheApplication.class, args);
    }

}
