package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
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

	/*
	 //Problem: Double Posting or Form Duplication problem with this code(refresh the page once submitted duplicate entry will be inserted)
		@PostMapping("/emp_add")
		public String saveEmployee(@ModelAttribute("emp") Employee emp, Map<String, Object> map) {
			String msg = empService.registerEmployee(emp);
			Iterable<Employee> allEmployees = empService.getAllEmployees();
			
			//keeping the results in model attribute
			map.put("resultMsg", msg);
			map.put("empList", allEmployees);
			
			//return LVN
			return "show_emp_report";
		}
	*/

	/*
		//Solution1. Implementing PRG(Post Redirect Get Pattern) 
	    //[refresh the page once submitted duplicate entry will not be inserted but you will not get result msg even when you submitted for the first time.]
		@PostMapping("/emp_add")
		public String saveEmployee(@ModelAttribute("emp") Employee emp, Map<String, Object> map) {
	
			//Model attribute Map<String, Object> is also shared memory specific to each request, which means data stored in first request
			//will only be accecible within the first request scope, second request will not access to it as its default scope is request scope.
	
			String msg = empService.registerEmployee(emp);
			
			//when we redirect the results from source handler to destination handler, both will have two different request and response objects
			//Hence results added to the model attribute map in source handler will not be available to the destination handler as model attributes have request scope as 
			// default scope and they available within the same request scope.
			//resultMsg will not be available to destination handler method
			map.put("resultMsg", msg);
			
			//return LVN
			return "redirect:emp_report";
		}
	*/

	/*
	 //Solution2. Implementing PRG(Post Redirect Get Pattern) keeping Flash attributes in RedirectAttributes obj
	//[refresh the page once submitted duplicate entry will not be inserted and you will get result msg when you submit request everytime, but if you refresh result msg will not come]
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {
	
		//RedirectAttributes are special shared memory which holds the attriubutes only during course of Redirection
		//i.e., once the Redirectio is over, attributes in this special shared memory will be vanished..
		//that's why these attributes are called FlashAttributes.
	
		String msg = empService.registerEmployee(emp);
	
		//keep the result as flash attribute
		attrs.addFlashAttribute("resultMsg", msg);
		
		//return LVN
		return "redirect:emp_report";
	}
	*/

	//Solution3. Implementing PRG(Post Redirect Get Pattern) keeping Flash attributes in HttpSession obj
	//[refresh the page once submitted duplicate entry will not be inserted and you will get result msg when you submit request everytime also when you refresh]
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp, HttpSession session) {

		//RedirectAttributes are special shared memory which holds the attriubutes only during course of Redirection
		//i.e., once the Redirectio is over, attributes in this special shared memory will be vanished..
		//that's why these attributes are called FlashAttributes.

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
	public String EditEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee employee) {
		String msg = empService.updateEmployee(employee);

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
