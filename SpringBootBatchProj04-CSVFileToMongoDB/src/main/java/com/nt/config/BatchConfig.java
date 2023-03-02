package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.nt.document.ExamResult;
import com.nt.listener.JobMonitoringListener;
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

	/*	//Using anonymous sub class and instance block 
		@Bean(name = "jciReader")
		public FlatFileItemReader<ExamResult> createReader() {
			FlatFileItemReader<ExamResult> reader = new FlatFileItemReader<ExamResult>();
			reader.setResource(new ClassPathResource("TopStudents.csv"));
			reader.setLineMapper(new DefaultLineMapper<ExamResult>() {
				{
					setLineTokenizer(new DelimitedLineTokenizer() {
						{
							setDelimiter(",");
							setNames("id", "dob", "percentage", "semester");
						}
					});
					setFieldSetMapper(new BeanWrapperFieldSetMapper<ExamResult>() {
						{
							setTargetType(ExamResult.class);
						}
					});
				}
			});
			return reader;
		}*/

	//Using Builder class
	@Bean(name = "ffiReader")
	public FlatFileItemReader<ExamResult> createReader() {
		return new FlatFileItemReaderBuilder<ExamResult>().name("file-reader")
				.resource(new ClassPathResource("TopStudents.csv")).delimited().delimiter(",")
				.names("id", "dob", "percentage", "semester").targetType(ExamResult.class).build();
	}

	@Bean(name = "ffiWriter")
	public MongoItemWriter<ExamResult> createWriter() {
		return new MongoItemWriterBuilder<ExamResult>().collection("SuperBrains").template(template).build();
	}

	@Bean(name = "step1")
	public Step createStep1() {
		return stepBuilderFactory.get("step1").<ExamResult, ExamResult>chunk(5).reader(createReader())
				.processor(processor).writer(createWriter()).build();
	}

	@Bean(name = "job1")
	public Job createJob1() {
		return jobBuilderFactory.get("job1").listener(listener).incrementer(new RunIdIncrementer()).start(createStep1())
				.build();
	}
}
