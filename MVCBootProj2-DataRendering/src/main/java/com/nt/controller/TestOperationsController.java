package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestOperationsController {

	//Request paths are case sensitive: Observe below two handler methods
	
	@GetMapping("/report")
	public String showReport1() {
		System.out.println("TestOperationsController.showReport1()");
		return "display_report1";
	}

	@GetMapping("/REPORT")
	public String showReport2() {
		System.out.println("TestOperationsController.showReport2()");
		return "display_report2";
	}
	
	//Handler mapped with multiple request paths

	@GetMapping({"/report1","/report2","/report3"})
	public String showReport() {
		System.out.println("TestOperationsController.showAll()");
		return "display_report";
	}
	
	//Hander methods with same request path but different request modes(get,post)
	
	//@RequestMapping(value="/report4",method=RequestMethod.GET)
	@GetMapping("/report4")
	public String showReport3() {
		System.out.println("TestOperationsController.showReport1()");
		return "display_report1";
	}
	
	//@RequestMapping(value="/report4",method=RequestMethod.POST)
	@PostMapping("/report4")
	public String showReport4() {
		System.out.println("TestOperationsController.showReport1()");
		return "display_report2";
	}
	
	//handler methods with same request mode and request path can be differenciated with global path
	//Check EMpOperationsController handler is having same request mode and request path as below.
	@GetMapping("/all")
	public String showAllStudentDetails() {
		return "display_report1";
	}
}
