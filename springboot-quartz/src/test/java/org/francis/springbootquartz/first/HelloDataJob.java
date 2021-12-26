package org.francis.springbootquartz.first;

import org.francis.springbootquartz.service.HelloService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

/**
 * @author Franc1s
 * @date 2021/12/25
 * @apiNote
 */
public class HelloDataJob implements Job {

    HelloService helloService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        StringJoiner joiner = new StringJoiner(" ")
                .add("HelloJob.execute")
                .add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")))
                .add(Thread.currentThread().getName())
                .add(jobExecutionContext.getTrigger().getKey().getName());
        System.out.println(joiner);
//        System.out.println(jobExecutionContext.getJobDetail().getJobDataMap().get("key1"));

    }
}
