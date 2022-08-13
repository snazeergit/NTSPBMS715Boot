package com.nt.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Employee> fetchEMpByDesg(String desg1, String desg2) {

		//Create StoredProcedureQuery object pointing to PL/SQL Procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_EMP_DETAILS_BY_DESG", Employee.class);

		//Register params
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

		//Set Values to IN params
		query.setParameter(1, desg1);
		query.setParameter(2, desg2);

		List<Employee> list = query.getResultList();
		return list;
	}

}
