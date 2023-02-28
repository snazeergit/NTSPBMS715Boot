package com.nt.runner;

import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchTestRunner implements CommandLineRunner {

	@Autowired
	private Job job;
	@Autowired
	private JobLauncher launcher;

	@Override
	public void run(String... args) throws Exception {
		//create Job Parameters
		JobParameters params = new JobParametersBuilder().addLong("run.id", new Random().nextLong(1000))
				.toJobParameters();
		//run the job
		JobExecution execution = launcher.run(job, params);
		System.out.println("Job Execution Status ::" + execution.getExitStatus());
	}
}
