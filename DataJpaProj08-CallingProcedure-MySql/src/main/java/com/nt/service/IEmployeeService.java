package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeService {
public List<Employee> fetchEmpByDesg(String desg1, String desg2);
}
