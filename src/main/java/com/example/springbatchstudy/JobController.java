package com.example.springbatchstudy;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.job.SimpleJob;
import org.springframework.batch.core.launch.*;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class JobController {

    private final JobRegistry jobRegistry;
    private final JobExplorer jobExplorer;
    private final JobOperator jobOperator;

    @PostMapping(value = "/batch/start")
    public String start(@RequestBody JobInfo jobInfo) throws NoSuchJobException, JobInstanceAlreadyExistsException, JobParametersInvalidException {

        Iterator<String> iterator = jobRegistry.getJobNames().iterator();

        for(Iterator<String> it = iterator; iterator.hasNext();) {
            SimpleJob job = (SimpleJob) jobRegistry.getJob(it.next());
            System.out.println("jobName : " + job.getName());
            jobOperator.start(job.getName(), "id=" + jobInfo.getId());
        }

        return "Batch is started";
    }

    @PostMapping(value = "/batch/stop")
    public String stop(@RequestBody JobInfo jobInfo) throws NoSuchJobException, JobInstanceAlreadyExistsException, JobParametersInvalidException, NoSuchJobExecutionException, JobExecutionNotRunningException {

        Iterator<String> iterator = jobRegistry.getJobNames().iterator();

        for(Iterator<String> it = iterator; iterator.hasNext();){
            SimpleJob job = (SimpleJob) jobRegistry.getJob(it.next());
            System.out.println("jobName : " + job.getName());

            Set<JobExecution> runningJobExecutions = jobExplorer.findRunningJobExecutions(job.getName());
            JobExecution jobExecution = runningJobExecutions.iterator().next();

            jobOperator.stop(jobExecution.getId());
        }

        return "Batch is stopped";
    }

    @PostMapping(value = "/batch/restart")
    public String restart(@RequestBody JobInfo jobInfo) throws NoSuchJobException, JobInstanceAlreadyExistsException, JobParametersInvalidException, NoSuchJobExecutionException, JobExecutionNotRunningException, JobInstanceAlreadyCompleteException, JobRestartException {

        Iterator<String> iterator = jobRegistry.getJobNames().iterator();

        for(Iterator<String> it = iterator; iterator.hasNext();){
            SimpleJob job = (SimpleJob) jobRegistry.getJob(it.next());
            System.out.println("jobName : " + job.getName());

            JobInstance lastJobInstance = jobExplorer.getLastJobInstance(job.getName());
            JobExecution lastJobExecution = jobExplorer.getLastJobExecution(lastJobInstance);

            jobOperator.restart(lastJobExecution.getId());
        }

        return "Batch is restarted";
    }


}
