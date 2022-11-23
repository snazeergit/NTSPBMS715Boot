package com.nt.service;

import java.util.Optional;

import com.nt.document.Employee;

public interface IEmployeeService {

	public String registerEmployee(Employee e);

	public Optional<Employee> showEmployeeById(Integer id);

}
