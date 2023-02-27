package com.nt;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Gives Spring Batch features through AutoConfiguration like giving
 * InMemoryJpbRepository, JobBuilderFactory,StepBuilderFactory and etc.
 */
@EnableBatchProcessing
@SpringBootApplication
public class SpringBootBatchProj01PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBatchProj01PocApplication.class, args);
	}

}
