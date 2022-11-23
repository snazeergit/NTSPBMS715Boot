package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public String saveEmployee(Employee e) {

		return "MongoDB doc is saved with id value :: " + empRepo.insert(e).getId();
	}

	@Override
	public List<Employee> showAllEmployees() {

		return empRepo.findAll();
	}

	@Override
	public List<Employee> saveAllEmployee(Iterable<Employee> e) {

		return empRepo.saveAll(e);
	}

}
