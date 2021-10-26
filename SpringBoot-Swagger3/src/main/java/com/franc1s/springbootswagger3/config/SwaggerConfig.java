package com.franc1s.springbootswagger3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.franc1s.springbootswagger3.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    @Bean
    ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        return apiInfoBuilder
                .description("vhr 项目")
                .contact(new Contact("javaboy", "https://www.javaboy.org", "11111@qq.com"))
                .version("v1.0")
                .title("API 测试文档")
                .license("hhh")
                .licenseUrl("www.baidu.com")
                .build();
    }
}
