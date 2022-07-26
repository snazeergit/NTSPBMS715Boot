package com.nt;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.entity.Actor;
import com.nt.service.IActorService;

@SpringBootApplication
public class DataJpaProj01CrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DataJpaProj01CrudRepositoryApplication.class, args);
		IActorService service = context.getBean("actorService", IActorService.class);

		//save(-)
		Actor actor = new Actor();
		//actor.setAid(43);
		actor.setAName("Nagarjuna");
		actor.setCategory("Hero");
		actor.setMobileNo(555555555L);
		String msg = service.registerActor(actor);
		System.out.println(msg);

		//saveAll(-)
		List<Actor> actors = List.of(new Actor("Allu Arjun", "Hero", 9933939393l),
				new Actor("Vijay", "Hero", 7767639393l), new Actor("Nani", "Hero", 88839393l));
		String msgs = service.registerAllActor(actors);
		System.out.println(msgs);

		//count()
		long count = service.fetchRecordsCount();
		System.out.println("Count ::" + count);

		//findAll()
		Iterable<Actor> allActors = service.fetchAllActors();
		allActors.forEach(System.out::println);

		//findAllById
		List<Integer> ids = List.of(48, 49, 50);
		Iterable<Actor> actorList = service.fetchActorsByIds(ids);
		actorList.forEach(System.out::println);

		//findById
		Optional<Actor> optional2 = service.fetchActorbyId(50);
		if (optional2.isPresent()) {
			Actor actor2 = optional2.get();
			System.out.println(actor2.toString());
		} else {
			throw new IllegalArgumentException("No actor found...");
		}

		//findById
		Actor actor3 = service.showActorById(50);
		System.out.println(actor3.toString());

	}

}
