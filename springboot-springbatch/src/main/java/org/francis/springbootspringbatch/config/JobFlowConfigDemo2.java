package org.francis.springbootspringbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
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
public class JobFlowConfigDemo2 {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Step jobFlowDemo2Step1(){
        return stepBuilderFactory.get("jobFlowDemo2Step1")
                .tasklet((stepContribution,chunkContext)->{
                    System.out.println("jobFlowDemo2Step1");
                    return RepeatStatus.FINISHED;
                }).build();
    }
    @Bean
    public Step jobFlowDemo2Step2(){
        return stepBuilderFactory.get("jobFlowDemo2Step2")
                .tasklet((stepContribution,chunkContext)->{
                    System.out.println("jobFlowDemo2Step2");
                    return RepeatStatus.FINISHED;
                }).build();
    }
    @Bean
    public Step jobFlowDemo2Step3(){
        return stepBuilderFactory.get("jobFlowDemo2Step3")
                .tasklet((stepContribution,chunkContext)->{
                    System.out.println("jobFlowDemo2Step3");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Flow jobFlowDemo2Flow1(){
        return new FlowBuilder<Flow>("jobFlowDemo2Flow1")
                .start(jobFlowDemo2Step1())
                .next(jobFlowDemo2Step2())
                .build();
    }
    @Bean
    public Job jobFlowDemo2Job1(){
        return jobBuilderFactory.get("jobFlowDemo2Job1")
                .start(jobFlowDemo2Flow1())
                .next(jobFlowDemo2Step3()).end()
                .build();
    }
}
