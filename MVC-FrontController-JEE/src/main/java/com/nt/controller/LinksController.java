package com.nt.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.nt.service.ILinksService;
import com.nt.service.LinksServiceImpl;

//Handler class
public class LinksController {
	
	private ILinksService service;

	public LinksController() {
		service = new LinksServiceImpl();
	}
	
	//handler method-1
	public String showWishMessage(HttpServletRequest req) {
		//use service
		String message = service.generateWishMessage();
		//keep result in request scope
		req.setAttribute("wmsg", message);
		//return Logical View Name(LVN) base which physical jsp file name and location will be decided
		return "wish_result";
	}
	
	//handler method-2
	public String showAllLanguages(HttpServletRequest req) {
		//use service
		Set<String> languages = service.fetchAllLanguages();
		//keep result in request scope
		req.setAttribute("langInfo", languages);
		//return Logical View Name(LVN)
		return "all_lang";
	}
}
