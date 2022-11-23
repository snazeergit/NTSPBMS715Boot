package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeService {

	public String saveEmployee(Employee e);

	public List<Employee> showAllEmployees();
	
	public List<Employee> saveAllEmployee(Iterable<Employee> e);
	
	public String searchEmployeeById(String id);
	
	public String modifyEmployeeById(String id, Double newSal);
	
	public String removeEmployeeById(String id);
	
	public List<Employee> showAllEmployeesInSortedOrder(boolean asc, String ...properties);
}
