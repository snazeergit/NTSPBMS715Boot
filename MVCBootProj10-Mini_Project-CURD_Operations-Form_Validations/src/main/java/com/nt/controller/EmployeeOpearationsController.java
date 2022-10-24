package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeOpearationsController {

	@Autowired
	private IEmployeeMgmtService empService;

	@Autowired
	private EmployeeValidator empValidator;

	@GetMapping("/")
	public String showHome() {

		//return LVN
		return "home";
	}

	@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String, Object> map) {

		//keeping the results in model attribute
		map.put("empList", empService.getAllEmployees());

		//return LVN
		return "show_emp_report";
	}

	@GetMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp) {

		//return LVN
		return "register_emp";
	}

	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp, HttpSession session, BindingResult errors) {

		//use Validator
		if (empValidator.supports(Employee.class)) {
			empValidator.validate(emp, errors);
			if (errors.hasErrors())//if form validation error messages are found
				return "register_emp";
		}

		String msg = empService.registerEmployee(emp);

		//keep the result as flash attribute
		session.setAttribute("resultMsg", msg);

		//redirect to destination handler
		return "redirect:emp_report";
	}

	@GetMapping("/emp_edit")
	public String showEditEmployeeForm(@RequestParam("eno") Integer no, @ModelAttribute("emp") Employee employee) {
		Employee employee2 = empService.getEmployeeByNo(no);

		//Copy data from source obj to dest obj
		BeanUtils.copyProperties(employee2, employee);

		//return LVN
		return "update_emp";
	}

	@PostMapping("/emp_edit")
	public String EditEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		String msg = empService.updateEmployee(emp);

		//use Validator
		if (empValidator.supports(Employee.class)) {
			empValidator.validate(emp, errors);
			if (errors.hasErrors())//if form validation error messages are found
				return "update_emp";
		}

		//add result message to flash attribute 
		attrs.addFlashAttribute("resultMsg", msg);

		//redirect to destination handler
		return "redirect:emp_report";
	}

	@GetMapping("/emp_delete")
	public String deleteEmployee(@RequestParam("eno") Integer no, RedirectAttributes attrs) {
		String msg = empService.deleteEmployeeByNo(no);

		//add result message to flash attribute 
		attrs.addFlashAttribute("resultMsg", msg);

		//redirect to destination handler
		return "redirect:emp_report";
	}

	/*
	This is not a handler method it's a ReferenceData method for deptno select box.
	This is a user-defined method allowing us to take List/Set/Arrays as return types.
	This method will be called automatically by DispatcherServlet while launching form page
	   and DS keeps the return values in SharedMemory having the given ModelAttribute name.
	*/
	@ModelAttribute("deptNoInfo")
	public List<Integer> RefDataForDeptNoSelectBox() {
		//use service
		return empService.fetchAllDeptNo();
	}

}
