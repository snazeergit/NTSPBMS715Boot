package com.nt.runner;

import java.util.Iterator;
import java.util.List;

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
		//saveEmp();
		saveAllEmp();
		//findAllEmp();
	}

	private void saveAllEmp() {
		Employee e1 = new Employee();
		e1.setEname("Suresh");
		e1.setEadd("Delhi");
		e1.setEno(104);
		e1.setSalary(90000.0);
		e1.setIsVaccinated(true);

		Employee e2 = new Employee();
		e2.setEname("Suresh");
		e2.setEadd("Delhi");
		e2.setEno(104);
		e2.setSalary(90000.0);
		e2.setIsVaccinated(true);
		empService.saveAllEmployee(List.of(e1, e2)).forEach(System.out::println);

	}

	private void findAllEmp() {
		empService.showAllEmployees().forEach(System.out::println);
	}

	private void saveEmp() {
		Employee e = new Employee();
		e.setEname("Suresh");
		e.setEadd("Delhi");
		e.setEno(104);
		e.setSalary(90000.0);
		e.setIsVaccinated(true);
		System.out.println(empService.saveEmployee(e));
	}

}
