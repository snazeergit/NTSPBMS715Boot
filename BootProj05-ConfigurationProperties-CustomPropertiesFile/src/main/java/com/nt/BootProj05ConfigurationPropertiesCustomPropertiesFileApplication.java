package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company;
import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj05ConfigurationPropertiesCustomPropertiesFileApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj05ConfigurationPropertiesCustomPropertiesFileApplication.class, args);
		Company company = context.getBean("company", Company.class);
		System.out.println(company);

		Employee employee = context.getBean("employee", Employee.class);
		System.out.println(employee);

		((ConfigurableApplicationContext) context).close();
	}

}
