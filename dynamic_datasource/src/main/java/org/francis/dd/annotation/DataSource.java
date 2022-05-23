package org.francis.dd.annotation;

import org.francis.dd.datasource.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Franc1s
 * @date 2022/5/15
 * @apiNote 这个注解将来可以加在某一个Service方法或类上，通过value指定数据源
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface DataSource {
    String value() default DataSourceType.DEFAULT_DS_NAME;
}
