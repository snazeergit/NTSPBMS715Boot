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
	public String registerEmployee(Employee e) {
		return "MongoDB doc is saved with id value :: " + empRepo.insert(e).getEno();
	}

	@Override
	public Optional<Employee> showEmployeeById(Integer id) {
		return empRepo.findById(id);
	}

}
