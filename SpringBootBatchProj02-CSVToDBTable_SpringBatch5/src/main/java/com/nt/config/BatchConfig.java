package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.Employee;
import com.nt.processor.EmployeeInfoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EmployeeInfoItemProcessor processor;
	@Autowired
	private DataSource ds;

	//Approach 3:
	//By using ReadyMade Builder class
	@Bean(name = "ffiReader")
	public FlatFileItemReader<Employee> createFFIReader() {
		return new FlatFileItemReaderBuilder<Employee>().name("file-reader")
				.resource(new ClassPathResource("Employee_Info.csv")).delimited()
				.names("empno", "ename", "eadd", "salary").targetType(Employee.class).build();
	}

	//Using Builder class
	@Bean(name = "jbiWriter")
	public JdbcBatchItemWriter<Employee> createJBIWriter() {
		return new JdbcBatchItemWriterBuilder<Employee>().dataSource(ds)
				.sql("INSERT INTO BATCH_EMPLOYEE_INFO VALUES(:empno,:ename,:eadd,:salary,:grossSalary,:netSalary)")
				.beanMapped().build();
	}

	
	@Bean(name = "step1")
	public Step createStep1(JobRepository repository, PlatformTransactionManager transactionManager) {
		return new StepBuilder("step1", repository).<Employee, Employee>chunk(5, transactionManager)
				.reader(createFFIReader()).processor(processor).writer(createJBIWriter()).build();
	}

	@Bean(name = "job1")
	public Job createJob1(JobRepository repository, Step step) {
		return new JobBuilder("job1", repository).listener(listener).incrementer(new RunIdIncrementer())
				.start(step).build();
	}
}
