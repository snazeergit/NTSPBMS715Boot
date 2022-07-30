package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IActorRepository;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IActorRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------------------");

		System.out.println("Suresh name actors info:: ");
		repository.findByaNameEquals("Suresh").forEach(System.out::println);
		System.out.println("-------------------------");
		
		System.out.println("Suresh name actors info:: ");
		repository.findByaNameIs("Suresh").forEach(System.out::println);
		System.out.println("-------------------------");
		
		System.out.println("Suresh name actors info:: ");
		repository.findByaName("Suresh").forEach(System.out::println);
		System.out.println("-------------------------");
		//TODO
		System.out.println("Actors whose aIds between 10 to 100:: ");
		repository.findByaIdBetween(10,100).forEach(System.out::println);
		System.out.println("-------------------------");
		
		System.out.println("Actors whose category is Hero:: ");
		repository.findByCategoryEqualsIgnoreCase("HERO").forEach(System.out::println);
		System.out.println("-------------------------");
		
		System.out.println("Actors whose names starting with V :: ");
		repository.findByaNameLike("V%").forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println("Actors whose names ending with a :: ");
		repository.findByaNameLike("%a").forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println("Actors whose names starting with V and ending with h:: ");
		repository.findByaNameLike("V%h").forEach(System.out::println);
		System.out.println("-------------------------");
		//The search letters used are case sensitive
		
		System.out.println("Actors names starting with V :: ");
		repository.findByaNameStartingWith("V").forEach(System.out::println);
		System.out.println("-------------------------");
		
		System.out.println("Actor names that contains the letter a :: ");
		repository.findByaNameContainingIgnoreCase("a").forEach(System.out::println);
		System.out.println("-------------------------");
	}

}
