package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.listener.JobMonitoringListener;
import com.nt.processor.BookDetailsProcessor;
import com.nt.reader.BookDetailsReader;
import com.nt.writer.BookDetailsWriter;

@EnableBatchProcessing
/*Gives Spring Batch features through AutoConfiguration like giving
 * InMemoryJpbRepository, JobBuilderFactory,StepBuilderFactory and etc.
 */
@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	@Autowired
	private BookDetailsReader bdReader;
	@Autowired
	private BookDetailsProcessor bdProcessor;
	@Autowired
	private BookDetailsWriter bdWriter;
	@Autowired
	private JobMonitoringListener jobListener;

	//Create Step object using StepBuilderFactory
	@Bean(name = "step1")
	public Step createStep1() {
		System.out.println("BatchConfig.creteStep1()");
		return stepFactory.get("step1").<String, String>chunk(1).reader(bdReader).processor(bdProcessor)
				.writer(bdWriter).build();
	}

	//Create Job using JobBuilderFactory
	@Bean(name = "job1")
	public Job createJob() {
		System.out.println("BatchConfig.createJob()");
		return jobFactory.get("job1").incrementer(new RunIdIncrementer()).listener(jobListener).start(createStep1())
				.build();
	}

}
