package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.persistance.IEmployeeDAO;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO dao;

	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl.EmployeeServiceImpl()");
	}

	@Override
	public List<Employee> fetchAllEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("EmployeeServiceImpl.fetchAllEmployeesByDesgs()");
		List<Employee> listEmp = dao.getEmployeesByDesgs(desg1, desg2, desg3);
		return listEmp;
	}

}
