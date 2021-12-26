package org.francis.springbootquartz.config;

import org.francis.springbootquartz.job.SpringJob1;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import javax.annotation.PostConstruct;

/**
 * @author Franc1s
 * @date 2021/12/26
 * @apiNote 如果已经持久化 数据库有表了就不需要在类里面初始化JobDetail跟Trigger
 */
public class JobConfig {
    /*@Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void initJob() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SpringJob1.class)
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .startNow()
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
    }*/
    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(SpringJob1.class)
                .withIdentity("job1")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .withIdentity("trigger1")
                .forJob("job1")
                .startNow()
                .build();
    }
}
