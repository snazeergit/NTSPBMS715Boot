package com.nt.service;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public Iterable<Employee> getAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(Integer eno);
	public String updateEmployee(Employee emp);
}
