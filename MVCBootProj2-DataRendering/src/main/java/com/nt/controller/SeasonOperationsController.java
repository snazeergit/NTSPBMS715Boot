package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinerService;

@Controller
public class SeasonOperationsController {

	@Autowired
	private ISeasonFinerService service;

	@RequestMapping("/")
	public String showHome() {
		return "welcome";
	}

	@RequestMapping("/season")
	public String showSeasons(Map<String, Object> map) {
		String season = service.findSeason();
		map.put("season", season);
		return "display";
	}
}
