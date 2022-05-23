package com.v11v.springboottransaction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTransactionApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        userService.transfer();
    }

}
