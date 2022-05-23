package org.francis.rabbitmqprovider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franc1s
 * @date 2022/1/3
 * @apiNote
 */
@RestController
public class HelloController {
    @Autowired
    ProviderService providerService;

    @GetMapping("/test/{msg}")
    public void test(@PathVariable String msg){
        providerService.test(msg);
    }

    @GetMapping("/test1")
    public void test() throws JsonProcessingException {
        providerService.test1(new ObjectMapper().writeValueAsString(new User(1L,"francis")));
    }
}
