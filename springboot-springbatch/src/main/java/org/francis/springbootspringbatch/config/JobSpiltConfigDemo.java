package org.francis.springbootspringbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.StringJoiner;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
//@Configuration
public class JobSpiltConfigDemo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Flow jobSpiltFlow1(){
        return new FlowBuilder<Flow>("jobSpiltFlow1")
                .start(stepBuilderFactory.get("jobSpiltStep1")
                    .tasklet((con,context)->{
                        System.out.println(new StringJoiner(" ")
                            .add(context.getStepContext().getStepName())
                            .add("has been executed on thread")
                            .add(Thread.currentThread().getName())
                            .toString());
                        return RepeatStatus.FINISHED;
                    }).build())
                .build();
    }
    @Bean
    public Flow jobSpiltFlow2(){
        return new FlowBuilder<Flow>("jobSpiltFlow2")
                .start(stepBuilderFactory.get("jobSpiltStep2")
                        .tasklet((con,context)->{
                            System.out.println(new StringJoiner(" ")
                                    .add(context.getStepContext().getStepName())
                                    .add("has been executed on thread")
                                    .add(Thread.currentThread().getName())
                                    .toString());
                            return RepeatStatus.FINISHED;
                        }).build())
                .build();
    }
    @Bean
    public Job jobSpiltJob1(){
        return jobBuilderFactory.get("jobSpiltJob1")
                .start(jobSpiltFlow1())
                .split(new SimpleAsyncTaskExecutor()).add(jobSpiltFlow2())
                .end()
                .build();
    }
}
