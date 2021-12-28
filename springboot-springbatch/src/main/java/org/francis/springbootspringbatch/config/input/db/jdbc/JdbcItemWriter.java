package org.francis.springbootspringbatch.config.input.db.jdbc;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
@Component
public class JdbcItemWriter implements ItemWriter<Customer> {
    @Override
    public void write(List<? extends Customer> items) throws Exception {
        for (Customer item : items) {
            System.out.println("item = " + item);
        }
    }
}
