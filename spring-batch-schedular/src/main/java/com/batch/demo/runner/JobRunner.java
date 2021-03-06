package com.batch.demo.runner;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.batch.demo.utils.Constants;

@Component
public class JobRunner {
	//private static final LogFactory LOGGER=LogFactory.getFactory();
	private static final Logger LOGGER=LoggerFactory.getLogger(JobRunner.class);
	private JobLauncher simpleJobLauncher;
	private Job job1;
	@Autowired
	JobRunner(JobLauncher simpleJobLauncher,Job job1)
	{
		this.simpleJobLauncher=simpleJobLauncher;
		this.job1=job1;
	}
	@Async
	public void runBatchJob()
	{
		JobParametersBuilder builder=new JobParametersBuilder();
		builder.addString(Constants.FILE_NAME_CONTEXT_KEY, "employee.csv");
		builder.addDate("date", new Date(), true);
		runJob(job1,builder.toJobParameters());
	}
	private void runJob(Job job, JobParameters jobParameters) {
		// TODO Auto-generated method stub
		
			try {
				JobExecution execution=simpleJobLauncher.run(job, jobParameters);
			} catch (JobExecutionAlreadyRunningException e) {
				// TODO Auto-generated catch block
                 LOGGER.info("job with  file name {} is always running :",jobParameters.getParameters().get(Constants.FILE_NAME_CONTEXT_KEY));
				e.printStackTrace();
			} catch (JobRestartException e) {
				// TODO Auto-generated catch block
				 LOGGER.info("job with  file name {} is not restart :",jobParameters.getParameters().get(Constants.FILE_NAME_CONTEXT_KEY));
				e.printStackTrace();
			} catch (JobInstanceAlreadyCompleteException e) {
				// TODO Auto-generated catch block
				 LOGGER.info("job with  file name {} is always completed :",jobParameters.getParameters().get(Constants.FILE_NAME_CONTEXT_KEY));
				e.printStackTrace();
			} catch (JobParametersInvalidException e) {
				// TODO Auto-generated catch block
				 LOGGER.info("invalid job parameters:",jobParameters.getParameters().get(Constants.FILE_NAME_CONTEXT_KEY));
				e.printStackTrace();
			}
		
		
	}
	

}
