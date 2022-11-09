package com.nt.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageService;

@Controller
public class ShowHomeController {

	@Autowired
	private IWishMessageService service;

	@RequestMapping("/")
	public String launchHomePage() {
		//return LVN
		return "welcome";
	}

	@RequestMapping("/wish")
	public String process1(Map<String, Object> map) {
		String msg = service.generateWishMessage();
		//add model attributes to shared memory
		map.put("resultMsg", msg);

		//return LVN
		return "show_result";
	}

}
