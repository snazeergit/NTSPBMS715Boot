package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Customer;

@SpringBootApplication
public class BootProj07YamlApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj07YamlApplication.class, args);
		Customer customer = context.getBean("customer", Customer.class);
		System.out.println(customer);
		((ConfigurableApplicationContext) context).close();

	}

}