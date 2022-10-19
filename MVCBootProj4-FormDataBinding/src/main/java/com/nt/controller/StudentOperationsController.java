package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/register")
	public String showRegistrationForm() {
		return "student_register";
	}

	//Possible attributes to be used within @ModelAttribute
	//@ModelAttribute(name = "std") Student sno
	//@ModelAttribute(value = "std") Student sno
	//@ModelAttribute("std") Student sno
	@PostMapping("/register")
	public String registerStudent(Map<String, Object> map, @ModelAttribute(name = "std") Student st) {
		System.out.println(st);
		System.out.println(map);
		return "result";
	}

}
