package org.francis.springbootquartz.first;

import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;


/**
 * @author Franc1s
 * @date 2021/12/25
 * @apiNote
 */
@SpringBootTest
public class _04_QuartzTest_JobData_Spring {
    @Test
    void jobDataTest(){
        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();
            // define the job and tie it to our HelloJob class
            JobDetail job = JobBuilder.newJob(HelloDataJob.class)
                    .usingJobData("key1","key1's value")
                    .withIdentity("job1", "group1")
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .usingJobData("trigger-key-1","trigger-key-1")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                    .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger1);
            TimeUnit.SECONDS.sleep(6);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
