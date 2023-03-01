package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.ExamResult;
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
	private DataSource ds;
	@Autowired
	private ExamResultProcessor processor;

	/*
		//Approach:1 Regular code
		@Bean(name = "jciReader")
		public JdbcCursorItemReader<ExamResult> createReader() {
			JdbcCursorItemReader<ExamResult> reader = new JdbcCursorItemReader<ExamResult>();
			reader.setDataSource(ds);
			reader.setSql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT");
			reader.setRowMapper((rs, rowNum) -> {
				ExamResult result = new ExamResult();
				result.setId(rs.getInt(1));
				result.setDob(rs.getDate(2));
				result.setPercentage(rs.getFloat(3));
				result.setSemester(rs.getInt(4));
				return result;
			});
			return reader;
		}
	
		@Bean(name = "ffiWriter")
		public FlatFileItemWriter<ExamResult> createWriter() {
			FlatFileItemWriter<ExamResult> writer = new FlatFileItemWriter<ExamResult>();
			writer.setResource(new ClassPathResource("TopStudents.csv"));
			//To get values from Model class object
			BeanWrapperFieldExtractor<ExamResult> extractor = new BeanWrapperFieldExtractor<ExamResult>();
			extractor.setNames(new String[] { "id", "dob", "percentage", "semester" });
			//Combines everything into csv file lines
			DelimitedLineAggregator<ExamResult> aggregator = new DelimitedLineAggregator<ExamResult>();
			aggregator.setDelimiter(",");
			aggregator.setFieldExtractor(extractor);
			writer.setLineAggregator(aggregator);
			return writer;
		}
	*/

	/*
	//Approach:2 Using anonymous sub class and instance block 
	@Bean(name = "jciReader")
	public JdbcCursorItemReader<ExamResult> createReader() {
	JdbcCursorItemReader<ExamResult> reader = new JdbcCursorItemReader<ExamResult>() {
		{
			setDataSource(ds);
			setSql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT");
			setRowMapper((rs, rowNum) -> {
				ExamResult result = new ExamResult();
				result.setId(rs.getInt(1));
				result.setDob(rs.getDate(2));
				result.setPercentage(rs.getFloat(3));
				result.setSemester(rs.getInt(4));
				return result;
			});
		}
	};
	return reader;
	}
	
	@Bean(name = "ffiWriter")
	public FlatFileItemWriter<ExamResult> createWriter() {
		FlatFileItemWriter<ExamResult> writer = new FlatFileItemWriter<ExamResult>() {//1st anonymous sub class
			{//1st instance block
				setResource(new ClassPathResource("TopStudents.csv"));
				setLineAggregator(new DelimitedLineAggregator<ExamResult>() {//2nd anonymous sub class
					{//2nd instance block
						setDelimiter(",");
						setFieldExtractor(new BeanWrapperFieldExtractor<ExamResult>() {//3rd anonymous sub class
							{//3rd instance block
								setNames(new String[] { "id", "dob", "percentage", "semester" });
							}//3rd instance block close
						}//3rd anonymous sub class
						);
					}//2nd instance block
				}//2nd anonymous sub class
				);
			}//1st instance block
		};//1st anonymous sub class
		return writer;
	}
	*/

	//Approach:3 Using Builder class
	@Bean(name = "jciReader")
	public JdbcCursorItemReader<ExamResult> createReader() {
		return new JdbcCursorItemReaderBuilder<ExamResult>().name("reader").dataSource(ds)
				.sql("SELECT ID,DOB,PERCENTAGE,SEMESTER FROM EXAM_RESULT").beanRowMapper(ExamResult.class).build();
	}

	@Bean(name = "ffiWriter")
	public FlatFileItemWriter<ExamResult> createWriter() {
		return new FlatFileItemWriterBuilder<ExamResult>().name("writer")
				.resource(new FileSystemResource("TopStudents.csv")).lineSeparator("\r\n").delimited().delimiter(",")
				.names(new String[] { "id", "dob", "percentage", "semester" }).build();
	}
	//new ClassPathResource("classpath:TopStudents.csv") or new FileSystemResource("TopStudents.csv")

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
