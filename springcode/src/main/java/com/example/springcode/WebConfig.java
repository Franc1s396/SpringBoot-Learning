package com.example.springcode;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author Franc1s
 * @date 2022/5/2
 * @apiNote
 */
//@Configuration
//@ComponentScan
public class WebConfig {
    //内嵌web容器工厂
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }
    //创建DispatcherServlet
    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }
    //注册DispatcherServlet,SpringMVC的入口
//    @Bean
//    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(DispatcherServlet dispatcherServlet){
//        DispatcherServletRegistrationBean registrationBean = new DispatcherServletRegistrationBean(dispatcherServlet, "/");
//        registrationBean.setLoadOnStartup(1);
//        return registrationBean;
//    }
    //如果用DispatcherServlet 初始化时默认添加的组件，并不会作为bean,给测试带来困扰
    // 加入RequestMappingHandlerMapping
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
        return new RequestMappingHandlerMapping();
    }

    //继续加入RequestMappingHandlerAdapter,会替换掉DispatcherServlet默认的4个HandlerAdapter

}
