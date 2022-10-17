package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamsController {
	
	@GetMapping("/")
	public String process() {
			//return LVN
		return "welcome";
	}


	@GetMapping("/data1")
	public String process1(@RequestParam("sno") int no, @RequestParam("sname") String name) {
		System.out.println(no + "   " + name);
		//return LVN
		return "show_result";
	}

	@GetMapping("/data2")
	public String process2(@RequestParam(required = false) Integer sno,
			@RequestParam(defaultValue = "PS1") String sname) {
		System.out.println(sno + "   " + sname);
		//return LVN
		return "show_result";
	}

	@GetMapping("/data3")
	public String process3(@RequestParam Integer sno, @RequestParam String sname, @RequestParam("sadd") String addrs[],
			@RequestParam("sadd") List<String> addrsList, @RequestParam("sadd") Set<String> addrsSet) {
		System.out.println(sno + "   " + sname + "  " + Arrays.toString(addrs) + "  " + addrsList + "  " + addrsSet);
		//return LVN
		return "show_result";
	}

	@GetMapping("/data4")
	public String process4(@RequestParam Integer sno, @RequestParam String sname, @RequestParam("sadd") String addrs) {
		System.out.println(sno + "   " + sname + "  " + addrs);
		//return LVN
		return "show_result";
	}

}
