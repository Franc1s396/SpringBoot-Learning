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
@MapperScan(basePackages = "com.franc1s.springbootmybatismulti.mapper2",sqlSessionFactoryRef = "sessionFactory2"
        ,sqlSessionTemplateRef = "sqlSessionTemplate2")
public class MybatisConfigTwo {

    @Autowired
    @Qualifier(value = "dsTwo")
    DataSource dataSource;

    @Bean
    SqlSessionFactory sessionFactory2(){
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
    SqlSessionTemplate sqlSessionTemplate2(){
        return new SqlSessionTemplate(sessionFactory2());
    }
}
