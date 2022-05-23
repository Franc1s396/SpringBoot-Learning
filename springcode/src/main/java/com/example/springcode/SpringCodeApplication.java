package com.example.springcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringCodeApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringCodeApplication.class);

    public static void main(String[] args) {
//        AnnotationConfigServletWebServerApplicationContext applicationContext =
//                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);
//        //作用：解析@RequestMapping 以及派生注解，生成路径与控制器方法的映射关系，在初始化时就完成
//        RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
//        Map<RequestMappingInfo, HandlerMethod> handlerMethods = handlerMapping.getHandlerMethods();
//        handlerMethods.forEach((requestMappingInfo, handlerMethod) -> {
//            System.out.println(requestMappingInfo+"="+handlerMethod);
//        });
        SpringApplication.run(SpringCodeApplication.class,args);
    }

}
