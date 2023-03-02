package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.nt.document.OExamResult;
import com.nt.listener.JobMonitoringListener;
import com.nt.model.IExamResult;
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
	private MongoTemplate template;
	@Autowired
	private ExamResultProcessor processor;

	//Using Builder class
	@Bean(name = "ffiReader")
	public FlatFileItemReader<IExamResult> createReader() {
		return new FlatFileItemReaderBuilder<IExamResult>().name("file-reader")
				.resource(new ClassPathResource("TopStudents.csv")).delimited().delimiter(",")
				.names("id", "dob", "percentage", "semester").targetType(IExamResult.class).build();
	}

	@Bean(name = "ffiWriter")
	public MongoItemWriter<OExamResult> createWriter() {
		return new MongoItemWriterBuilder<OExamResult>().collection("SuperBrains").template(template).build();
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
