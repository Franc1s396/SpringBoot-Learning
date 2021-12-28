package org.francis.springbootspringbatch.config.listenerDemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
//@Configuration
public class MyListenerJobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Job myListenerJob(){
        return jobBuilderFactory.get("myListenerJob")
                .start(myListenerStep1())
                .listener(new MyJobListener())
                .build();
    }

    @Bean
    public Step myListenerStep1() {
        return stepBuilderFactory.get("MyListenerStep1")
                .<String,String>chunk(2)
                .faultTolerant()
                .listener(new MyChunkListener())
                .reader(reader())
                .writer(writer())
                .build();
    }

    @Bean
    public ItemWriter<String> writer() {
        return new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> items) throws Exception {
                for (String item : items) {
                    System.out.println("item = " + item);
                }
            }
        };
    }

    @Bean
    public ItemReader<String> reader() {
        return new ListItemReader<>(Arrays.asList("first","second","third"));
    }
}
