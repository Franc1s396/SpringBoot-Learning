package org.francis.springbootspringbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
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
public class flowDecisionDemo {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Step firstStep(){
        return stepBuilderFactory.get("firstStep")
                .tasklet(((stepContribution, chunkContext) -> {
                    System.out.println("firstStep has been executed");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public Step oddStep(){
        return stepBuilderFactory.get("oddStep")
                .tasklet(((stepContribution, chunkContext) -> {
                    System.out.println("oddStep has been executed");
                    return RepeatStatus.FINISHED;
                })).build();
    }

    @Bean
    public Step evenStep(){
        return stepBuilderFactory.get("evenStep")
                .tasklet(((stepContribution, chunkContext) -> {
                    System.out.println("evenStep has been executed");
                    return RepeatStatus.FINISHED;
                })).build();
    }
    @Bean
    public JobExecutionDecider myDecider(){
        return new MyDecider();
    }
    @Bean
    public Job flowDecisionJob(){
        return jobBuilderFactory.get("flowDecisionJob")
                .start(firstStep())
                .next(myDecider())
                .from(myDecider()).on("EVEN").to(evenStep())
                .from(myDecider()).on("ODD").to(oddStep())
                .from(oddStep()).on("*").to(myDecider())
                .end().build();
    }
}
