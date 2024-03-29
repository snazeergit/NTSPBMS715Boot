package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.listener.JobMonitoringListener;
import com.nt.processor.BookDetailsProcessor;
import com.nt.reader.BookDetailsReader;
import com.nt.writer.BookDetailsWriter;

/*Gives Spring Batch features through AutoConfiguration like giving
 * InMemoryJpbRepository, JobBuilderFactory,StepBuilderFactory and etc.
 */
@EnableBatchProcessing
@Configuration
public class BatchConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private JobRepository jobRepository;
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
		//here chunk(2) means it reads first record and then reads second record the process first record and then process second record
		//then writes both the records to Destination in one go. Chunk size represents no of records the it can write to destination in one transaction.
		return stepBuilderFactory.get("step1").<String, String>chunk(2).reader(bdReader).processor(bdProcessor)
				.writer(bdWriter).build();
	}

	//Create Job using JobBuilderFactory
	@Bean(name = "job1")
	public Job createJob() {
		System.out.println("BatchConfig.createJob()");
		return jobBuilderFactory.get("job1").incrementer(new RunIdIncrementer()).listener(jobListener)
				.start(createStep1()).build();
	}

}
