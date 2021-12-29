package org.francis.springbootspringbatch.config.operator;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.ListableJobLocator;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.converter.DefaultJobParametersConverter;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author Franc1s
 * @date 2021/12/29
 * @apiNote
 */
@Configuration
public class JobOperatorDemoConfig implements StepExecutionListener, ApplicationContextAware {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private JobExplorer jobExplorer;
    @Autowired
    private JobRegistry jobRegistry;
    @Autowired
    private ApplicationContext applicationContext;

    Map<String, JobParameter> jobParameterMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor() throws Exception {
        JobRegistryBeanPostProcessor postProcessor = new JobRegistryBeanPostProcessor();
        postProcessor.setJobRegistry(jobRegistry);
        postProcessor.setBeanFactory(applicationContext.getAutowireCapableBeanFactory());
        postProcessor.afterPropertiesSet();
        return  postProcessor;
    }

    @Bean
    public JobOperator jobOperator() {
        SimpleJobOperator jobOperator = new SimpleJobOperator();
        jobOperator.setJobLauncher(jobLauncher);
        jobOperator.setJobParametersConverter(new DefaultJobParametersConverter());
        jobOperator.setJobRepository(jobRepository);
        jobOperator.setJobExplorer(jobExplorer);
        jobOperator.setJobRegistry(jobRegistry);
        return jobOperator;
    }

    @Bean
    public Job jobOperatorJob() {
        return jobBuilderFactory.get("jobOperatorJob")
                .start(jobOperatorStep())
                .build();
    }

    @Bean
    public Step jobOperatorStep() {
        return stepBuilderFactory.get("jobOperatorStep")
                .listener(this)
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("jobOperatorStep running with parameter:" + jobParameterMap.get("job2param").getValue());
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        jobParameterMap = stepExecution.getJobParameters().getParameters();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
