package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeService {

	public String saveEmployee(Employee e);

	public List<Employee> saveAllEmployee(Iterable<Employee> e);

	public List<Employee> showAllEmployees();
}
