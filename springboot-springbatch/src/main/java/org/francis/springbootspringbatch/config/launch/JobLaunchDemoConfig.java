package org.francis.springbootspringbatch.config.launch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.batch.runtime.context.StepContext;
import java.util.Map;

/**
 * @author Franc1s
 * @date 2021/12/29
 * @apiNote
 */
@Configuration
public class JobLaunchDemoConfig implements StepExecutionListener {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;
    private Map<String, JobParameter> parameterMap;
    @Bean
    public Job jobLaunchDemoJob(){
        return jobBuilderFactory.get("jobLaunchDemoJob")
                .start(jobLaunchDemoStep())
                .build();
    }

    @Bean
    public Step jobLaunchDemoStep() {
        return stepBuilderFactory.get("jobLaunchDemoStep")
                .listener(this)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("jobLaunchDemoStep running...");
                    System.out.println("job1param = " + parameterMap.get("job1param"));
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        parameterMap=stepExecution.getJobParameters().getParameters();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
