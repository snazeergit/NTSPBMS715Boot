package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@Component
public class LayeredAppTestingRunner implements CommandLineRunner {

	@Autowired
	private PayrollOperationsController controller;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("LayeredAppTestingRunner.run()");
		try {
			List<Employee> allEmployeesByDesgs = controller.showAllEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			allEmployeesByDesgs.forEach(emp -> {
				System.out.println(emp);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
