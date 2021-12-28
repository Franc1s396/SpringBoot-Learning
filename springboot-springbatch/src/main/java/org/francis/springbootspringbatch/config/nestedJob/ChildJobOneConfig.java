package org.francis.springbootspringbatch.config.nestedJob;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
//@Configuration
public class ChildJobOneConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step childJobStep1(){
        return stepBuilderFactory.get("childJobStep1")
                .tasklet(((stepContribution, chunkContext) -> {
                    System.out.println("childJobStep1");
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }
    @Bean
    public Job childJob1(){
        return jobBuilderFactory.get("childJob1")
                .start(childJobStep1())
                .build();
    }
}
