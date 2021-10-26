package com.franc1s.springbootmybatismulti.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.franc1s.springbootmybatismulti.mapper1",sqlSessionFactoryRef = "sessionFactory1"
        ,sqlSessionTemplateRef = "sqlSessionTemplate1")
public class MybatisConfigOne {

    @Autowired
    @Qualifier(value = "dsOne")
    DataSource dataSource;

    @Bean
    SqlSessionFactory sessionFactory1(){
        SqlSessionFactory sqlSessionFactory=null;
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate1(){
        return new SqlSessionTemplate(sessionFactory1());
    }
}
