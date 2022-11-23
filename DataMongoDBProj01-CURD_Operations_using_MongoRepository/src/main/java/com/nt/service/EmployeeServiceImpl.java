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

	@Override
	public String searchEmployeeById(String id) {
		Optional<Employee> optional = empRepo.findById(id);
		if (optional.isEmpty())
			return "Document not found";
		else
			return optional.get().toString();
	}

	@Override
	public String modifyEmployeeById(String id, Double newSal) {
		Optional<Employee> optional = empRepo.findById(id);
		if (optional.isEmpty())
			return "Document not found";
		else {
			Employee e = optional.get();
			e.setSalary(newSal);
			empRepo.save(e);
			return "Docuemnt found and updated";
		}
	}

	@Override
	public String removeEmployeeById(String id) {
		Optional<Employee> optional = empRepo.findById(id);
		if (optional.isEmpty())
			return "Document not found";
		else {
			empRepo.deleteById(id);
			return "Document found and deleted";
		}
	}

	@Override
	public List<Employee> showAllEmployeesInSortedOrder(boolean asc, String... properties) {
		//Create the Sort object
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		//Get the docs by Sorting
		List<Employee> empList = empRepo.findAll(sort);
		return empList;
	}

}
