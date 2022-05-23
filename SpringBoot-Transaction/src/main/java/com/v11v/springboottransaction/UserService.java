package com.v11v.springboottransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Service
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserService2 userService2;

    @Transactional
    public void transfer() {
        jdbcTemplate.update("update user set age = ? where id=?;", 1111, 2);
        userService2.update();
        int i = 1 / 0;
    }


}
