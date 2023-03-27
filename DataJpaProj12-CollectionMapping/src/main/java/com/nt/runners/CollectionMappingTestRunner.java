package com.nt.runners;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.EmployeeInfo;
import com.nt.repository.IEmployeeInfoRepository;

@Component
public class CollectionMappingTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeInfoRepository repository;

	@Override
	public void run(String... args) throws Exception {
		/*EmployeeInfo emp = new EmployeeInfo("Raja", List.of("Rani", "Ravi", "Rama"), Set.of(9999L, 8888L, 7777L),
				Map.of("Aadhar", 1234L, "PAN", 5678L, "Passport", 9876L));
		
		//Insert operation
		EmployeeInfo save = repository.save(emp);
		System.out.println("Employee record has been saved with id " + save.getEno());
		*/
		
		//Fetch operation
		repository.findAll().forEach(System.out::println);

	}

}
