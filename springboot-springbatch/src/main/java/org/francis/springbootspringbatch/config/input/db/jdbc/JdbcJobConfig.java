package org.francis.springbootspringbatch.config.input.db.jdbc;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
@Configuration
public class JdbcJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    @Qualifier("jdbcItemWriter")
    private ItemWriter<Customer> jdbcItemWriter;
    @Autowired
    DataSource dataSource;

    @Bean
    public Job jdbcJob1() {
        return jobBuilderFactory.get("jdbcJob1")
                .start(jdbcStep1())
                .build();
    }

    @Bean
    public Step jdbcStep1() {
        return stepBuilderFactory.get("jdbcStep1")
                .<Customer, Customer>chunk(100)
                .reader(jdbcReader())
                .writer(jdbcItemWriter)
                .build();
    }

    @Bean
    @StepScope
    public ItemReader<? extends Customer> jdbcReader() {
        JdbcPagingItemReader<Customer> itemReader = new JdbcPagingItemReader<>();
        itemReader.setDataSource(dataSource);
        itemReader.setFetchSize(100);
        itemReader.setRowMapper((rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setFirstName(rs.getString("firstName"));
            customer.setLastName(rs.getString("lastName"));
            customer.setBirthday(rs.getString("birthday"));
            return customer;
        });
        MySqlPagingQueryProvider provider = new MySqlPagingQueryProvider();
        provider.setSelectClause("id,firstName,lastName,birthday");
        provider.setFromClause("from Customer");
        HashMap<String, Order> sortKeys = new HashMap<>();
        sortKeys.put("id", Order.ASCENDING);
        provider.setSortKeys(sortKeys);
        itemReader.setQueryProvider(provider);
        return itemReader;
    }
}
