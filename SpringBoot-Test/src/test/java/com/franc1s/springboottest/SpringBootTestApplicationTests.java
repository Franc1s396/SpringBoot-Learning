package com.franc1s.springboottest;

import com.fasterxml.jackson.core.JsonEncoding;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class SpringBootTestApplicationTests {

    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;

    @BeforeEach
    void setup(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    void contextLoads() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/99").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

}
