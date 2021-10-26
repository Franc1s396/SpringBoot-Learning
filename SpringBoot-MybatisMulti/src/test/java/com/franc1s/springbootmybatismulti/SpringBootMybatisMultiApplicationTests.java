package com.franc1s.springbootmybatismulti;

import com.franc1s.springbootmybatismulti.mapper1.UserMapper1;
import com.franc1s.springbootmybatismulti.mapper2.UserMapper2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootMybatisMultiApplicationTests {
@Autowired
private UserMapper1 userMapper1;
@Autowired
private UserMapper2 userMapper2;
    @Test
    void contextLoads() {
        System.out.println(userMapper1.findAll());
        System.out.println(userMapper2.findAll());
    }

}
