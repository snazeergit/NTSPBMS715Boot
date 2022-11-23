package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, Integer> {

	public List<Employee> findBySalaryBetween(Double start, Double end);

	public Employee findByEmail(String email);
	
}
