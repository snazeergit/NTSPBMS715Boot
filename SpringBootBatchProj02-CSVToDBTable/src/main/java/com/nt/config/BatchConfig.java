package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.Employee;
import com.nt.processor.EmployeeInfoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EmployeeInfoItemProcessor processor;
	@Autowired
	private DataSource ds;

	//Approach 1:
	/*@Bean(name = "ffiReader")
	public FlatFileItemReader<Employee> createFFIReader() {
		//create Reader object
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
		//set CSV file as resource
		reader.setResource(new ClassPathResource("Employee_Info.csv"));
		//create LineMapper object to get each line from CSV file
		DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<Employee>();
		//create LineTOkenizer to get tokens from each line
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setNames("empno", "ename", "eadd", "salary");
		//create FieldSetMapper to set the  tokens to Model class object properties
		BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<Employee>();
		fieldSetMapper.setTargetType(Employee.class);
		//set Tokenizer, FiledSetMapper objects to LineMapper
		lineMapper.setFieldSetMapper(fieldSetMapper);
		lineMapper.setLineTokenizer(tokenizer);
		//set LineMapper to Reader object
		reader.setLineMapper(lineMapper);
		return reader;
	}
	
	@Bean(name = "jbiWriter")
	public JdbcBatchItemWriter<Employee> createJBIWriter() {
		//create JdbcBatchItemWriter
		JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>();
		//set DataSource
		writer.setDataSource(ds);
		//set INSERT SQL query with named parameters
		writer.setSql("INSERT INTO BATCH_EMPLOYEE_INFO VALUES(:empno,:ename,:eadd,:salary,:grossSalary,:netSalary)");
		//create BeanPropertyItemSqlParameterSourceProvider object
		BeanPropertyItemSqlParameterSourceProvider<Employee> sourceProvider = new BeanPropertyItemSqlParameterSourceProvider<Employee>();
		//set SourceProvider to writer object
		writer.setItemSqlParameterSourceProvider(sourceProvider);
		return writer;
	}*/

	//Approach 2:
	/*@Bean(name = "ffiReader")
	public FlatFileItemReader<Employee> createFFIReader() {
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
		reader.setResource(new ClassPathResource("Employee_Info.csv"));
		reader.setLineMapper(new DefaultLineMapper<Employee>() { //anonymous sub class
			{//instance block
				//method called from instance block
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						//methods called from instance block
						setDelimiter(",");
						setNames("empno", "ename", "eadd", "salary");
					}
				});
				//method called from instance block
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
					{
						//method called from instance block
						setTargetType(Employee.class);
					}
				});
			}//instance block close
		}//anonymous sub class close
		);
		return reader;
	}
	
	@Bean(name = "jbiWriter")
	public JdbcBatchItemWriter<Employee> createJBIWriter() {
		//create JdbcBatchItemWriter
		JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>() {//anonymous sub class
			{//instance block
				//methods called from instance block
				setDataSource(ds);
				setSql("INSERT INTO BATCH_EMPLOYEE_INFO VALUES(:empno,:ename,:eadd,:salary,:grossSalary,:netSalary)");
				setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
			}//instance block close
		}//anonymous sub class close
		;
		return writer;
	}*/

	//Approach 3:
	//By using ReadyMade Builder class
	@Bean(name = "ffiReader")
	public FlatFileItemReader<Employee> createFFIReader() {
		return new FlatFileItemReaderBuilder<Employee>().name("file-reader").resource(new ClassPathResource("Employee_Info.csv"))
				.delimited().names("empno", "ename", "eadd", "salary").targetType(Employee.class).build();
	}

	//Using Builder class
	@Bean(name = "jbiWriter")
	public JdbcBatchItemWriter<Employee> createJBIWriter() {
		return new JdbcBatchItemWriterBuilder<Employee>().dataSource(ds)
				.sql("INSERT INTO BATCH_EMPLOYEE_INFO VALUES(:empno,:ename,:eadd,:salary,:grossSalary,:netSalary)")
				.beanMapped().build();
	}

	
	@Bean(name = "step1")
	public Step createStep1() {
		return stepBuilderFactory.get("step1").<Employee, Employee>chunk(5).reader(createFFIReader())
				.processor(processor).writer(createJBIWriter()).build();
	}

	@Bean(name = "job1")
	public Job createJob1() {
		return jobBuilderFactory.get("job1").listener(listener).incrementer(new RunIdIncrementer()).start(createStep1())
				.build();
	}
}
