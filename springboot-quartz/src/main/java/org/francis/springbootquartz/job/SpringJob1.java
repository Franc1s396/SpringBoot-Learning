package org.francis.springbootquartz.job;

import org.francis.springbootquartz.service.HelloService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

/**
 * @author Franc1s
 * @date 2021/12/26
 * @apiNote
 */
public class SpringJob1 extends QuartzJobBean {

    @Autowired
    HelloService helloService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        StringJoiner joiner = new StringJoiner(" ")
                .add("HelloJob.execute")
                .add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss")))
                .add(helloService.hello());
        System.out.println(joiner);
    }
}
