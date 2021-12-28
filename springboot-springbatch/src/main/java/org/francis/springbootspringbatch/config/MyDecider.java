package org.francis.springbootspringbatch.config;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

/**
 * @author Franc1s
 * @date 2021/12/28
 * @apiNote
 */
public class MyDecider implements JobExecutionDecider {
    private int count=0;
    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        count++;
        if (count % 2 ==0)
            return new FlowExecutionStatus("EVEN");
        else
            return new FlowExecutionStatus("ODD");
    }
}
