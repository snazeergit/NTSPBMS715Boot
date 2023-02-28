package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.Employee;

@Component
public class EmployeeInfoItemProcessor implements ItemProcessor<Employee, Employee> {
	public EmployeeInfoItemProcessor() {
		System.out.println("EmployeeInfoItemProcessor.EmployeeInfoItemProcessor()");
	}

	@Override
	public Employee process(Employee emp) throws Exception {
		if (emp.getSalary() >= 50000) {
			emp.setGrossSalary((float) Math.round(emp.getSalary() + emp.getSalary() * 0.4f));
			emp.setNetSalary((float) Math.round(emp.getGrossSalary() - emp.getGrossSalary() * 0.2f));
			return emp;
		} else {
			return null;//other employees will be filtered here
		}
	}
}
