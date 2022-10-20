package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOpearationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String, Object> map) {
		map.put("empList", empService.getAllEmployees());
		return "show_emp_report";
	}

	@GetMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp) {
		return "register_emp";
	}

	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp, Map<String, Object> map) {
		String msg = empService.registerEmployee(emp);
		Iterable<Employee> allEmployees = empService.getAllEmployees();
		map.put("resultMsg", msg);
		map.put("empList", allEmployees);
		return "show_emp_report";
	}
}
