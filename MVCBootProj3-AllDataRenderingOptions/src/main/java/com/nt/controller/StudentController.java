package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Student;

@Controller
public class StudentController {

	//1. Passing simple values
	@GetMapping
	public String sendData1(Map<String, Object> map) {
		map.put("name", "Nazeer");
		return "simple_data1";
	}

	//2. Passing Collections and Arrays
	@GetMapping("/report1")
	public String sendData2(Map<String, Object> map) {
		map.put("favColors", new String[] { "red", "green" });
		map.put("nickNames", List.of("raja", "kaja"));
		map.put("phones", Set.of(99999L, 8888L));
		map.put("identities", Map.of("voterID", 232312, "PAN", 3434));

		//return "simple_data2.1";
		return "simple_data2.2";
	}

	//3. Passing Model class object
	@GetMapping("/report2")
	public String sendData3(Map<String, Object> map) {
		Student st = new Student();
		st.setSno(10);
		st.setSname("Raghu");
		st.setSalary(1232.0f);
		st.setVaccinated(true);
		map.put("studentInfo", st);

		return "simple_data3";
	}

	//4. Passing Collection of Model class objects
	@GetMapping("/report3")
	public String sendData4(Map<String, Object> map) {
		List<Student> stdList = List.of(new Student(10, "Ranga", 1232f, true), new Student(20, "Billa", 3432f, false));
		map.put("stdInfo", stdList);
		return "simple_data4";
	}

}
