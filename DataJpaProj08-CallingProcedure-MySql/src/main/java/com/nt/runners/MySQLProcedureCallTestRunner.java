package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeService;

@Component
public class MySQLProcedureCallTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService service;

	@Override
	public void run(String... args) throws Exception {
		service.fetchEmpByDesg("salesman", "clerk").forEach(System.out::println);
	}

}
