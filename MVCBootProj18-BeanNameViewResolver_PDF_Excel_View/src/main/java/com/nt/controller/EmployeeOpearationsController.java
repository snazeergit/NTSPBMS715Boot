package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOpearationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	@GetMapping("/")
	public String showHome() {

		//return LVN
		return "home";
	}

	@GetMapping("/report")
	public String showEmployeeReport(Map<String, Object> map, @RequestParam("type") String type) {

		//keeping the results in model attribute
		map.put("empList", empService.getAllEmployees());
		
		if (type.equalsIgnoreCase("pdf"))
			return "pdf_report";
		else
			return "excel_report";
	}

}
