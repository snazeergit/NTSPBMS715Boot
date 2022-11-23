package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService empService;

	@Override
	public void run(String... args) throws Exception {
		empService.findEmployeeInSalaryRange(10000.0, 100000.0).forEach(System.out::println);
		System.out.println("Employee Details:: " + empService.findEmployeeWithEmail("raja@gmail.com"));
	}

}
