package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//Both works
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class SpringBootBatchProj04CsvFileToMongoDb1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchProj04CsvFileToMongoDb1Application.class, args);
	}

}
