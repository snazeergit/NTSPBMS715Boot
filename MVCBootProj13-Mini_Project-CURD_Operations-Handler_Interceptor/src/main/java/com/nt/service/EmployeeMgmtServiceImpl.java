package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IDepartmentRepository;
import com.nt.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;

	@Autowired
	private IDepartmentRepository deptRepo;

	@Override
	public Iterable<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		return "employee saved with id value " + empRepo.save(emp).getEno();
	}

	@Override
	public Employee getEmployeeByNo(Integer eno) {
		Employee employee = empRepo.findById(eno).orElseThrow(() -> new IllegalArgumentException());
		return employee;
	}

	@Override
	public String updateEmployee(Employee emp) {
		return "Employee with ID " + empRepo.save(emp).getEno() + " is updted successfully";
	}

	@Override
	public String deleteEmployeeByNo(Integer eno) {
		empRepo.deleteById(eno);
		return "Employee with ID " + eno + " has been deleted successfuly";
	}

	@Override
	public List<Integer> fetchAllDeptNo() {
		//ue repository
		List<Integer> deptNoList = deptRepo.getAllDeptNo();
		return deptNoList;
	}

	@Override
	public boolean isDesignationRejectedList(String desg) {
		if (desg.equalsIgnoreCase("TeamLeader"))
			return true;
		else
			return false;
	}

	@Override
	public Page<Employee> getEmployeeReportDataByPage(Pageable pageable) {

		return empRepo.findAll(pageable);
	}
}
