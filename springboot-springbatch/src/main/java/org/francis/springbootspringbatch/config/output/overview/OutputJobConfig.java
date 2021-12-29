package org.francis.springbootspringbatch.config.output.overview;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Franc1s
 * @date 2021/12/29
 * @apiNote
 */
//@Configuration
public class OutputJobConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    @Autowired
    ItemWriter<String> outputItemWriter;

    @Bean
    public Job outputJob() {
        return jobBuilderFactory.get("outputJob")
                .start(outputStep())
                .build();

    }

    @Bean
    public Step outputStep() {
        return stepBuilderFactory.get("outputStep")
                .<String,String>chunk(10)
                .reader(outputItemReader())
                .writer(outputItemWriter)
                .build();
    }

    @Bean
    public ListItemReader<String> outputItemReader() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("item"+i);
        }
        return new ListItemReader<>(list);
    }
}
