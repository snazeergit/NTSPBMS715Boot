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

	//Deafault values initialed in model class obj will be displayed in form comp
	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute("std") Student st) {
		System.out.println(st);
		return "student_register";
	}

	//user input values into form comp will be injected into Model attribute
	@PostMapping("/register")
	public String registerStudent(Map<String, Object> map, @ModelAttribute("std1") Student st) {
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
