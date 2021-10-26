package com.franc1s.springbootrestful;

import com.franc1s.springbootrestful.dao.UserDao;
import com.franc1s.springbootrestful.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootResTfulApplicationTests {
@Autowired
    UserDao userDao;
    @Test
    void contextLoads() {
        userDao.save(new User(1L,"mwc","123"));
    }

}
