package com.springbatchtutorial;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/triggerjob") public class restapi
{


    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job myjob;

    @GetMapping("/job")
    public void triggermyjob(){
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("myname" ,  "hellowwtoString()")
                 .toJobParameters();
        try {
            System.out.println("helow api called ");
            jobLauncher.run(myjob, jobParameters);
            System.out.println("helow api called finish ");

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

}
