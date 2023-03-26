package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;
import com.nt.view.ResultView;
import com.nt.view.ResultView1;
import com.nt.view.ResultView2;
import com.nt.view.ResultView3;

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

		/*System.out.println("Actors whose category is Hero:: ");
		repository.findByCategoryEqualsIgnoreCase("HERO").forEach(System.out::println);
		System.out.println("-------------------------");*/

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

		//Static Projections

		System.out.println("aname and aid whose category is hero :: ");
		Iterable<ResultView> iterable = repository.findByCategoryEqualsIgnoreCase("hero");
		iterable.forEach(view -> {
			System.out.println(view.getAid() + "  " + view.getAname());
		});
		System.out.println("-------------------------");

		//This method may through if the it return multiple records means if we have same actor or multiple actors having 
		//same mobileNo it will through IncorrectResultSizeDataAccessException
		System.out.println("Actor Name and ID whose mobile no is 11111:: ");
		ResultView view1 = repository.findByMobileNo(11111l);
		if (view1 != null)
			System.out.println(view1.getAid() + "  " + view1.getAname());
		else
			System.err.println("Oops....! Given mobile no not found");
		System.out.println("-------------------------");

		System.out.println("Actor Name and ID whose mobile no is 11111:: ");
		Actor actor = repository.findByMobileNoIs(11111l);
		if (actor != null)
			System.out.println(actor.getAid() + "  " + actor.getAname());
		else
			System.err.println("Oops....! No Actor found with the given mobile no.");
		System.out.println("-------------------------");

		//Dynamic Projections
		//Using ResultView1 as type interface
		System.out.println("Actor Id and Actor Name whose category is containging letter S:: ");
		Iterable<ResultView1> it = repository.findByCategoryContainingIgnoreCase("S", ResultView1.class);
		it.forEach(view -> {
			System.out.println(view.getAid() + "  " + view.getAname());
		});
		System.out.println("-------------------------");

		System.out.println("Actor category and Actor Mobile No whose category is containging letter S:: ");
		Iterable<ResultView2> it2 = repository.findByCategoryContainingIgnoreCase("S", ResultView2.class);
		it2.forEach(view -> {
			System.out.println(view.getCategory() + "  " + view.getMobileNo());
		});
		System.out.println("-------------------------");

		System.out.println("Actor Id , Actor Name and Category whose category is containging letter S:: ");
		Iterable<ResultView3> it3 = repository.findByCategoryContainingIgnoreCase("S", ResultView3.class);
		it3.forEach(view -> {
			System.out.println(view.getAid() + "  " + view.getAname() + "   " + view.getCategory());
		});
		System.out.println("-------------------------");
	}

}
