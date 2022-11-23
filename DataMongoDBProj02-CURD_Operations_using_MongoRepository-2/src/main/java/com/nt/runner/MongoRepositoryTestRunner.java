package com.nt.runner;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.service.IEmployeeService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService empService;

	@Override
	public void run(String... args) throws Exception {
		//regEmp();
		showEmpById();
	}

	private void regEmp() {
		Employee e = new Employee();
		e.setEno(new Random().nextInt(10000));
		e.setEname("Nazeer");
		e.setEadd("Nellore");
		e.setSalary(90000.0);
		e.setIsVaccinated(true);
		System.out.println(empService.registerEmployee(e));
	}

	private void showEmpById() {
		Optional<Employee> optional = empService.showEmployeeById(7976);
		if (optional.isEmpty())
			System.out.println("Document not found");
		else
			System.out.println("Employee Details::" + optional.get());
	}
}
