package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmpOperationsController {

	@GetMapping("/all")
	public String showAllEmpDetails() {
		return "display_report2";
	}
}
