package org.francis.springbootspringbatch.config.output.overview;

import org.francis.springbootspringbatch.config.input.db.jdbc.Customer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Franc1s
 * @date 2021/12/29
 * @apiNote
 */
//@Configuration
public class OutputJobConfig2 {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    DataSource dataSource;
    @Bean
    public Job outputJob2(){
        return jobBuilderFactory.get("outputJob2")
                .start(outputStep2())
                .build();
    }

    @Bean
    public Step outputStep2() {
        return stepBuilderFactory.get("outputStep2")
                .<Customer,Customer>chunk(10)
                .reader(jdbcReader())
                .writer(jdbcWriter())
                .build();
    }

    @Bean
    public ItemWriter<? super Customer> jdbcWriter() {
        JdbcBatchItemWriter<Object> itemWriter = new JdbcBatchItemWriter<>();
        itemWriter.setDataSource(dataSource);
        itemWriter.setSql("insert into customer(id,firstName,lastName,birthday) values "+
                "");
        itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return itemWriter;
    }

    @Bean
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
