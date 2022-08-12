package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IActorRepository;

@Component
public class NativeSQLQueryMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IActorRepository repository;

	@Override
	public void run(String... args) throws Exception {

		/*int count = repository.insertActor("Suesh", "Hero", 8888L);
		System.out.println(count == 0 ? "Record not inserted" : "Record inserted");*/
		
		System.out.println("Date:: "+repository.showDate());
	}

}
