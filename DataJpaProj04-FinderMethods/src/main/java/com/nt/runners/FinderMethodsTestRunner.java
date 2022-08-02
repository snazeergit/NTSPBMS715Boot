package com.nt.runners;

import java.util.List;

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

		System.out.println("Suresh name actors info1:: ");
		repository.findByAnameEquals("Suresh").forEach(System.out::println);
		System.out.println("-------------------------");

		System.out.println("Suresh name actors info2:: ");
		repository.findByAnameIs("Suresh").forEach(System.out::println);
		System.out.println("-------------------------");

		System.out.println("Suresh name actors info3:: ");
		repository.findByAname("Suresh").forEach(System.out::println);
		System.out.println("-------------------------");
		//TODO
		System.out.println("Actors whose aIds between 10 to 100:: ");
		repository.findByAidBetween(10, 100).forEach(System.out::println);
		System.out.println("-------------------------");

		System.out.println("Actors whose category is Hero:: ");
		repository.findByCategoryEqualsIgnoreCase("HERO").forEach(System.out::println);
		System.out.println("-------------------------");

		System.out.println("Actors whose names starting with V :: ");
		repository.findByAnameLike("V%").forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println("Actors whose names ending with a :: ");
		repository.findByAnameLike("%a").forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println("Actors whose names starting with V and ending with h:: ");
		repository.findByAnameLike("V%h").forEach(System.out::println);
		System.out.println("-------------------------");
		//The search letters used are case sensitive

		System.out.println("Actors names starting with V :: ");
		repository.findByAnameStartingWith("V").forEach(System.out::println);
		System.out.println("-------------------------");

		System.out.println("Actor names that contains the letter a :: ");
		repository.findByAnameContainingIgnoreCase("a").forEach(System.out::println);
		System.out.println("-------------------------");

		System.out.println("List all the Actors whose categories are Megastar or Comedian in ascending order :: ");
		repository.findByCategoryInIgnoreCaseOrderByAnameAsc(List.of("Megastar", "Comedian"))
				.forEach(System.out::println);
		System.out.println("-------------------------");

		System.out.println("Actor names that contains the letter a :: ");
		repository.findByAnameContainingIgnoreCase("a").forEach(System.out::println);
		System.out.println("-------------------------");

		System.out.println("Actor with aid from 180 to 190 :: ");
		repository.findByAidGreaterThanEqualAndAidLessThanEqual(180, 190).forEach(System.out::println);
		System.out.println("-------------------------");

		System.out.println(
				"Actor whose aid's greater than 190  and less than 180 or  whose category is neither Hero nor Comedian :: ");
		repository.findByAidGreaterThanAndAidLessThanOrCategoryNotInIgnoreCase(190, 180, "Hero", "Comedian")
				.forEach(System.out::println);
		System.out.println("-------------------------");
	}

}
