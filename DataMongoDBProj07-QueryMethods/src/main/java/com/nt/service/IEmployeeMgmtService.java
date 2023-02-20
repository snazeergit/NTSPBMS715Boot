package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {
	public List<Object[]> showEmpDataByAddrs(String addrs);

	public List<Employee> showEmpAllDataByAddrs(String addrs);

	public List<Employee> showEmpAllDataByAddrsAndName(String addrs, String name);

	public List<Employee> showEmpAllDataBySalaryRange(Double startSalary, Double endSalary);

	public List<Employee> showEmpAllDataByAddresses(String address1, String address2);

	public List<Employee> showEmpAllDataByEnameInitialChars(String initialChars);
}
