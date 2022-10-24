package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public Iterable<Employee> getAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeByNo(Integer eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeByNo(Integer eno);
	
	public List<Integer> fetchAllDeptNo();
	public boolean isDesignationRejectedList(String desg);
}
