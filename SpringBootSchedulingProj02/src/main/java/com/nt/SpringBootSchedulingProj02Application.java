package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootSchedulingProj02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSchedulingProj02Application.class, args);
		System.out.println("App started at ::" + new Date());
	}

}
