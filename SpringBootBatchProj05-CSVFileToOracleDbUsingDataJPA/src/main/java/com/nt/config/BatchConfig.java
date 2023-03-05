package com.nt.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.IExamResult;
import com.nt.model.OExamResult;
import com.nt.processor.ExamResultProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	@Autowired
	private ExamResultProcessor processor;

	//Using Builder class
	@Bean(name = "ffiReader")
	public FlatFileItemReader<IExamResult> createReader() {
		return new FlatFileItemReaderBuilder<IExamResult>().name("csv-reader")
				.resource(new ClassPathResource("TopStudents.csv")).delimited().delimiter(",")
				.names("id", "dob", "percentage", "semester").targetType(IExamResult.class).build();
	}

	@Bean(name = "ffiWriter")
	public JpaItemWriter<OExamResult> createWriter() {
		return new JpaItemWriterBuilder<OExamResult>().entityManagerFactory(entityManagerFactory).build();
	}

	@Bean(name = "step1")
	public Step createStep1() {
		return stepBuilderFactory.get("step1").<IExamResult, OExamResult>chunk(5).reader(createReader())
				.processor(processor).writer(createWriter()).build();
	}

	@Bean(name = "job1")
	public Job createJob1() {
		return jobBuilderFactory.get("job1").listener(listener).incrementer(new RunIdIncrementer()).start(createStep1())
				.build();
	}
}
