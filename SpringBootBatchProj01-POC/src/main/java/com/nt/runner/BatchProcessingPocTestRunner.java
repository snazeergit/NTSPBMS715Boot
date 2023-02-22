package com.nt.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchProcessingPocTestRunner implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;

	@Override
	public void run(String... args) throws Exception {
		//prepare Job Parameters
		JobParameters params = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
		//Run the job
		JobExecution execution = jobLauncher.run(job, params);
	}

}
