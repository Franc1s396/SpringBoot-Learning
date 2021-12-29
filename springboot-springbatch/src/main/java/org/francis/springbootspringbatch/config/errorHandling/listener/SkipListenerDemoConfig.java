package org.francis.springbootspringbatch.config.errorHandling.listener;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author Franc1s
 * @date 2021/12/29
 * @apiNote
 */
//@Configuration
public class SkipListenerDemoConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;
    @Autowired
    StepBuilderFactory stepBuilderFactory;

}
