package org.francis.repeat_submit.config;

import org.francis.repeat_submit.filter.RepeatableRequestFilter;
import org.francis.repeat_submit.interceptor.RepeatSubmitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Franc1s
 * @date 2022/5/23
 * @apiNote
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    RepeatSubmitInterceptor repeatSubmitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**");
    }

    @Bean
    FilterRegistrationBean<RepeatableRequestFilter> repeatableRequestFilterFilterRegistrationBean() {
        FilterRegistrationBean<RepeatableRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RepeatableRequestFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
