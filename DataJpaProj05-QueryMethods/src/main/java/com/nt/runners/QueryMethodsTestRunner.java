package com.nt.runners;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IActorRepository;

@Component
public class QueryMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IActorRepository repository;

	@Override
	public void run(String... args) throws Exception {

		/*List<Actor> actors = repository.searchActorsByCategory("Heroin");
		actors.forEach(System.out::println);*/
		repository.searchActorsByCategory("Heroin").forEach(System.out::println);

		repository.findActorsByMobileNo(9999l, 8888l, 7777l, 6666l).forEach(System.out::println);

		/*List<Object[]> row = repository.findActorsDataByCategories("Hero", "Heroin");
		for (Object[] objects : row) {
			for (Object object : objects) {
				System.out.print(object + "  ");
			}
			System.out.println();
		}*/
		repository.findActorsDataByCategories("Hero", "Heroin").forEach(row -> {
			for (Object object : row)
				System.out.print(object + "  ");
			System.out.println();
		});

		System.out.println("Actor Name:: " + repository.findActorNameByMobileNo(7777l));

		Object aggregateData[] = (Object[]) repository.getActorsAggregateData();
		System.out.println("Count of Records:: " + aggregateData[0]);
		System.out.println("Max aid:: " + aggregateData[1]);
		System.out.println("Min aid:: " + aggregateData[2]);
		System.out.println("Sum:: " + aggregateData[3]);
		System.out.println("Avg:: " + aggregateData[4]);

		System.out.println(repository.getActorDataByMaxActorId());

		int count = repository.updateActorMobileNoByAid(9090l, 2382);
		System.out.println(count == 1 ? "Actor mobile no updated" : "Actor not found with given id");

		int count1 = repository.deleteActorByCategory("Comedian");
		System.out.println(count1 >= 1 ? count1 + " Actor(s) deleted" : "No actor found with given category");
	}

}
