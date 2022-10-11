package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowHomeController {

	@RequestMapping("/home")
	public String launchHomePage() {
		//return LVN
		return "welcome";
	}

	//Working with ModelAttribute types (or) Working with parameter types of handler method

	@RequestMapping("/process1")
	public String process1(Map<String, Object> map) {
		System.out.println("ShowHomeController.process1():: Shared memory Object class:" + map.getClass());

		//add model attributes to shared memory
		map.put("attribute1", "Welcome Nazeer! ");
		map.put("SysDate", LocalDateTime.now());

		//return LVN
		return "show_data";
	}

	@RequestMapping("/process2")
	public String process2(Model model) {
		System.out.println("ShowHomeController.process1():: Shared memory Object class:" + model.getClass());

		//add model attributes to shared memory
		model.addAttribute("attribute1", "Welcome Dilshad! ");
		model.addAttribute("SysDate", LocalDateTime.now());

		//return LVN
		return "show_data";
	}

	@RequestMapping("/process3")
	public String process3(ModelMap modelMap) {
		System.out.println("ShowHomeController.process1():: Shared memory Object class:" + modelMap.getClass());

		//add model attributes to shared memory
		modelMap.addAttribute("attribute1", "Welcome Armaan! ");
		modelMap.addAttribute("SysDate", LocalDateTime.now());

		//return LVN
		return "show_data";
	}

	//Working with Handler method return types

	@RequestMapping("/process4")
	public Model process4() {
		//Manually creating shared memory
		Model model = new BindingAwareModelMap();

		//add model attributes to shared memory
		model.addAttribute("attribute1", "Welcome Sardar! ");
		model.addAttribute("SysDate", LocalDateTime.now());

		//return model obj not LVN hence in this case requesting mapping become LVN:  process4
		return model;
	}

	@RequestMapping("/process5")
	public Map<String, Object> process5() {
		//Manually creating shared memory
		Map<String, Object> map = new BindingAwareModelMap();
		//add model attributes to shared memory
		map.put("attribute1", "Welcome Rajiya! ");
		map.put("SysDate", LocalDateTime.now());

		//return model obj not LVN hence in this case requesting mapping become LVN:  process5
		return map;
	}

	@RequestMapping("/process6")
	public ModelAndView process6() {

		//Manually creating shared memory
		ModelAndView mvn = new ModelAndView();
		//add model attributes to shared memory
		mvn.addObject("attribute1", "Welcome Munni! ");
		mvn.addObject("SysDate", LocalDateTime.now());

		//place LVN to MovelAndView object
		mvn.setViewName("show_data");

		//mvn containes LVN and it will lunch show_data.jsp file
		return mvn;
	}

	//If handler method return type is void then request path will be taken as LVN
	@RequestMapping("/process7")
	public void process7(Map<String, Object> map) {

		//add model attributes to shared memory
		map.put("attribute1", "Welcome Gilli Gajjalu! ");
		map.put("SysDate", LocalDateTime.now());

		//it takes request path as LVN : process7.jsp
	}

	//If handler method return null then request path will be taken as LVN
	@RequestMapping("/process8")
	public String process8(Map<String, Object> map) {

		//add model attributes to shared memory
		map.put("attribute1", "Welcome Chemma Chekka! ");
		map.put("SysDate", LocalDateTime.now());

		//it takes request path as LVN as it is returning null : process7.jsp
		return null;
	}

	//req forwarding (Handler chaining)
	@RequestMapping("/process9")
	public String process9() {
		System.out.println("ShowHomeController.process9()::Source Handler method forwarding req to");
		//forwrding the request to destination handler method whose request path is /process10 hence its forward:process10
		return "forward:process10";
	}

	@RequestMapping("/process10")
	public String process10() {
		System.out.println("ShowHomeController.process10()::Destination Handler method");
		//return LVN 
		return "req_fwd";
	}

	//request redirecting  (Handler chaining)
	@RequestMapping("/process11")
	public String process11() {
		System.out.println("ShowHomeController.process11()::Source Handler method redirecting req to");
		//redirecting the request to destination handler method whose request path is /process12 hence its redirect:process12
		return "redirect:process12";
	}

	@RequestMapping("/process12")
	public String process12() {
		System.out.println("ShowHomeController.process12()::Destination Handler method");
		//return LVN 
		return "req_rdt";
	}

	//getting req, res objects in the handler method
	@RequestMapping("/process13")
	public String process13(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("attribute1", "Welcome to HttpServlet");
		req.setAttribute("SysDate", LocalDateTime.now());
		//return LVN 
		return "show_data";
	}

	//passing HttpSession object the handler method
	@RequestMapping("/process14")
	public String process14(HttpSession session) {
		session.setAttribute("attribute1", "Welcome to HttpSession");
		session.setAttribute("SysDate", LocalDateTime.now());
		//return LVN 
		return "show_data";
	}

	//Passing ServletContext, ServletConfig objects to handler method
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private ServletConfig servletConfig;

	@RequestMapping("/process15")
	public String process15(Map<String, Object> map) {
		String contextPath = servletContext.getContextPath();
		System.out.println("Web application context path ::" + contextPath);
		String servletName = servletConfig.getServletName();
		System.out.println("DispatcherServlet Logical Name ::" + servletName);

		//add model attributes to shared memory
		map.put("attribute1", contextPath);
		map.put("SysDate", servletName);

		//return LVN
		return "show_data";
	}

	//sending the output from handler method directly to browser without involving ViewResolver and view components
	@RequestMapping("/process16")
	public void process16(HttpServletResponse res) throws IOException {
		//get PrintWriter class obj
		PrintWriter pw = res.getWriter();
		//set MIME type
		res.setContentType("text/html");
		//write data directly to browser
		pw.println("<h1 style=\"color: blue; text-align: center\">output is directly from handler method no ViewComponents(.jsp files) or ViewResolvers(InternalResourceViewResolver) are involved... </h1>");
		//since the PrintWriter object is used to write the message to the browser directly
		//the option of taking the request path name as the LVN is gone.
	}
}
