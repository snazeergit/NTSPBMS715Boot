package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeMgmtService;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		/*service.showEmpDataByAddrs("hyd").forEach(row -> {
			for (Object val : row) {
				System.out.println(val + " ");
			}
		});*/
		service.showEmpDataByAddrs("Hyd").forEach(System.out::println);
		System.out.println("============================");
		service.showEmpAllDataByAddrsAndName("Hyd", "Raja").forEach(System.out::println);
		System.out.println("============================");
		service.showEmpAllDataBySalaryRange(80000d, 100000d).forEach(System.out::println);
		System.out.println("============================");
		service.showEmpAllDataByAddresses("Hyd", "Nellore").forEach(System.out::println);
		System.out.println("============================");
		service.showEmpAllDataByEnameInitialChars("N").forEach(System.out::println);

	}

}
