package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repositary.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public List<Object[]> showEmpDataByAddrs(String addrs) {
		return empRepo.getEmpDataByAddrs(addrs);
	}

	@Override
	public List<Employee> showEmpAllDataByAddrs(String addrs) {
		return empRepo.getEmpAllDataByAddrs(addrs);
	}

	@Override
	public List<Employee> showEmpAllDataByAddrsAndName(String addrs, String name) {
		return empRepo.getEmpAllDataByAddrsAndName(addrs, name);
	}

	@Override
	public List<Employee> showEmpAllDataBySalaryRange(Double startSalary, Double endSalary) {
		return empRepo.getEmpAllDataBySalaryRange(startSalary, endSalary);
	}

	@Override
	public List<Employee> showEmpAllDataByAddresses(String address1, String address2) {
		return empRepo.getEmpAllDataByAddresses(address1, address2);
	}

	@Override
	public List<Employee> showEmpAllDataByEnameInitialChars(String initialChars) {
		return empRepo.getEmpAllDataByEnameInitialChars(initialChars);
	}

}
