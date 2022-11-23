package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public List<Employee> findEmployeeInSalaryRange(Double start, Double end) {
		List<Employee> empList = empRepo.findBySalaryBetween(start, end);
		return empList;
	}

	@Override
	public Employee findEmployeeWithEmail(String mail) {
		return empRepo.findByEmail(mail);
	}

}
