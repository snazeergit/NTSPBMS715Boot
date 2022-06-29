package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj08ComplexYamlApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj08ComplexYamlApplication.class, args);
		Employee employee = context.getBean("emp", Employee.class);
		System.out.println(employee);

		((ConfigurableApplicationContext) context).close();
	}

}
