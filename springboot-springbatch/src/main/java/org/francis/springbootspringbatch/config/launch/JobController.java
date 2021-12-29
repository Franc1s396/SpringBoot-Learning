package org.francis.springbootspringbatch.config.launch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Franc1s
 * @date 2021/12/29
 * @apiNote
 */
@RestController
public class JobController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job jobLaunchDemoJob;

    @GetMapping("/job/{job1param}")
    public String runJob1(@PathVariable String job1param) {
        System.out.println("Request to run job1 with param " + job1param);
        JobParameters jobParameters = new JobParametersBuilder().addString("job1param", job1param).toJobParameters();
        try {
            jobLauncher.run(jobLaunchDemoJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
        return "";
    }
}
