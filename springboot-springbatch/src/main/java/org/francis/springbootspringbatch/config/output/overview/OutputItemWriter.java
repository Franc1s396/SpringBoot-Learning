package org.francis.springbootspringbatch.config.output.overview;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Franc1s
 * @date 2021/12/29
 * @apiNote
 */
@Component
public class OutputItemWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> items) throws Exception {
        System.out.println("items.size() = " + items.size());
    }
}
