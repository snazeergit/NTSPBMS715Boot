package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//Both Works
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringBootBatchProj04CsvFileToMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchProj04CsvFileToMongoDbApplication.class, args);
	}

}
