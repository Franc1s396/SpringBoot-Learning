package org.francis.springbootspringbatch.config.jobParameterDemo;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
//@Configuration
public class JobParametersConfig implements StepExecutionListener {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    private Map<String, JobParameter> parameters;

    @Bean
    public Job myJobParametersJob() {
        return jobBuilderFactory.get("myJobParametersJob")
                .start(myJobParametersStep())
                .build();
    }

    @Bean
    public Step myJobParametersStep() {
        return stepBuilderFactory.get("myJobParametersStep")
                .listener(this)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Parameter is =>"+parameters.get("info"));
                    return RepeatStatus.FINISHED;
                }).build();

    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        parameters = stepExecution.getJobParameters().getParameters();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
