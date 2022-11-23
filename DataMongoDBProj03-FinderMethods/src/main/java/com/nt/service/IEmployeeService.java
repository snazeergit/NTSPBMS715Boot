package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeService {

	public List<Employee> findEmployeeInSalaryRange(Double start, Double end);

	public Employee findEmployeeWithEmail(String mail);

}
