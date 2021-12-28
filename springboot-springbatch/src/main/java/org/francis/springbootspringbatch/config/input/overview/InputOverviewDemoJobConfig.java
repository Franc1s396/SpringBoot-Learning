package org.francis.springbootspringbatch.config.input.overview;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
//@Configuration
public class InputOverviewDemoJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Job InputOverviewDemoJob(){
        return jobBuilderFactory.get("InputOverviewDemoJob")
                .start(inputOverviewDemoStep())
                .build();
    }

    @Bean
    public Step inputOverviewDemoStep() {
        return stepBuilderFactory.get("inputOverviewDemoStep")
                .<String,String> chunk(2)
                .reader(inputOverviewDemoReader())
                .writer(items -> {
                    for (String item : items) {
                        System.out.println("item = " + item);
                    }
                }).build();
    }

    @Bean
    public InputOverviewItemReader inputOverviewDemoReader() {
        List<String> data= Arrays.asList("one","two","three");
        return new InputOverviewItemReader(data);
    }
}
