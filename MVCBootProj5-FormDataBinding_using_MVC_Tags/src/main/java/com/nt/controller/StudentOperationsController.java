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
	public String showRegistrationForm(@ModelAttribute("std") Student st) {
		System.out.println(st);
		return "student_register";
	}

	@PostMapping("/register")
	public String registerStudent(Map<String, Object> map, @ModelAttribute("std") Student st) {
		System.out.println(st);
		String grade=null;
		grade=st.getAvg()>=75? "First Class with Distinction":
					st.getAvg()>=60? "First Class":
						st.getAvg()>=50?"Second Class":
							st.getAvg()>=40?"Third Class":
								st.getAvg()>=30?"Just Pass" : "fail";
		map.put("result", grade);
		return "result";
	}

}
