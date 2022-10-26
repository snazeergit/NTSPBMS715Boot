package com.nt.interceptor;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws ServletException, IOException {
		System.out.println("TimeCheckInterceptor.preHandle()");

		//the below restriction will not apply to home page
		if (req.getServletPath().equalsIgnoreCase("/"))
			return true;

		//the below restriction will not apply to pages with request path(/emp_report)
		//this will let you access the Employee Report page
		if (req.getServletPath().equalsIgnoreCase("/emp_report"))
			return true;

		/*
		 //the below restriction will not apply to pages with request path(/emp_add)
		//This will let you add the employees from Employee report
		if (req.getServletPath().equalsIgnoreCase("/emp_add"))
			return true;
		*/

		/*
		//the below restriction will not apply to pages with request path(/emp_edit)
		//This will let you edit the employees from Employee report
		if (req.getServletPath().equalsIgnoreCase("/emp_edit"))
			return true;
		*/

		/*
		//the below restriction will not apply to pages with request path(/emp_delete)
		//This will let you delete the employees from Employee report
		if (req.getServletPath().equalsIgnoreCase("/emp_delete"))
			return true;
		*/

		//get System Date and Time
		LocalDateTime ldt = LocalDateTime.now();
		//get current hour of the day
		int hour = ldt.getHour();
		//restriction: condition to allow requests: reqs will be processed only between 9 am to 5 pm
		if (hour < 9 || hour > 17) {
			RequestDispatcher rd = req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		return true;
	}
}
