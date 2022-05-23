package com.example.springcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Franc1s
 * @date 2022/5/2
 * @apiNote
 */
@Controller
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public ModelAndView test1(HttpServletResponse response) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("name", "mwc");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        new ObjectMapper().writeValue(writer, map);
        return null;
    }

    @GetMapping("/test2")
    public ModelAndView test2(@RequestParam("name") String name) {
        log.debug("test2{}", name);
        return null;
    }

}
