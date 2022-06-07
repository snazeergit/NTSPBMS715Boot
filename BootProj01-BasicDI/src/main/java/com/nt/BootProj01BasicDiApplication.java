package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01BasicDiApplication {

	@Bean(name = "ldt")
	public LocalDateTime createLTD() {
		System.out.println("BootProj01BasicDiApplication.createLTD()");
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj01BasicDiApplication.class, args);
		WishMessageGenerator generator = context.getBean("wmg", WishMessageGenerator.class);
		String message = generator.generateWishMessage();
		System.out.println("Message : " + message);
		((ConfigurableApplicationContext) context).close();
	}

}
