package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	@GetMapping("/customer_register")
	public String showCustomerFormPage(@ModelAttribute("cust") Customer cust) {
		System.out.println("CustomerOperationsController.showCustomerFormPage()");
		return "show_customer_form";
	}

	@PostMapping("/customer_register")
	public String customerFormPageSubmission(@ModelAttribute("cust") Customer cust, Map<String, Object> map) {
		System.out.println("CustomerOperationsController.customerFormPageSubmission()");
		map.put("custData", cust);
		return "show_result";
	}

	@InitBinder
	public void myBinder(ServletRequestDataBinder binder) {
		System.out.println("CustomerOperationsController.myBinder()");
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
