package com.nt.runners;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorService;

@Component
public class CrudRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IActorService service;

	@Override
	public void run(String... args) throws Exception {

		//registerActor(-)
		Actor actor = new Actor();
		//actor.setAid(43);
		actor.setAName("Nagarjuna");
		actor.setCategory("Hero");
		actor.setMobileNo(555555555L);
		String msg = service.registerActor(actor);
		System.out.println(msg);

		//registerAllActor(-)
		List<Actor> actors = List.of(new Actor("Allu Arjun", "Hero", 9933939393l),
				new Actor("Vijay", "Hero", 7767639393l), new Actor("Nani", "Hero", 88839393l),
				new Actor("Chiranjeevi", "Megastar", 999999999l), new Actor("Balakrishna", "Hero", 77777777l),
				new Actor("Vijay", "Hero", 999999999l), new Actor("Suresh", "Hero", 999999999l),
				new Actor("Venkatesh", "Hero", 77777777l), new Actor("Suresh", "Hero", 555555555l),
				new Actor("Nagarjuna", "Hero", 555555555l), new Actor("Ramesh", "Hero", 77777777l),
				new Actor("Chiranjeevi", "Megastar", 999999999l), new Actor("Balakrishna", "Hero", 77777777l),
				new Actor("Vijay", "Hero", 999999999l), new Actor("Suresh", "Hero", 999999999l),
				new Actor("Venkatesh", "Hero", 77777777l), new Actor("Suresh", "Hero", 555555555l),
				new Actor("Nagarjuna", "Hero", 555555555l), new Actor("Ramesh", "Hero", 77777777l));
		String msgs = service.registerAllActor(actors);
		System.out.println(msgs);

		//fetchRecordsCount()
		long count = service.fetchRecordsCount();
		System.out.println("Count ::" + count);

		//fetchAllActors()
		Iterable<Actor> allActors = service.fetchAllActors();
		allActors.forEach(System.out::println);

		//fetchActorsByIds()
		List<Integer> ids = List.of(68, 79, 80);
		Iterable<Actor> actorList = service.fetchActorsByIds(ids);
		actorList.forEach(System.out::println);

		//fetchActorbyId()
		Optional<Actor> optional2 = service.fetchActorbyId(70);
		if (optional2.isPresent()) {
			Actor actor2 = optional2.get();
			System.out.println(actor2.toString());
		} else {
			throw new IllegalArgumentException("No actor found...");
		}

		//showActorById()
		Actor actor3 = service.showActorById(70);
		System.out.println(actor3.toString());

		//isActorAvailable()
		boolean available = service.isActorAvailable(90);
		System.out.println("is Actor available " + available);

		//updateActorMobileNo()
		System.out.println(service.updateActorMobileNo(78, 9999999999L));

		//updateActor()
		Actor actor4 = new Actor();
		actor.setAName("Nagma");
		actor.setCategory("Heroin");
		actor.setMobileNo(555577777L);
		System.out.println(service.updateActor(actor4));

		//registerOrUpdateActor()
		System.out.println(service.registerOrUpdateActor(actor4));

		//removeActorById()
		System.out.println(service.removeActorById(89));

		//removeActor()
		System.out.println(service.removeActor(actor4));

		//removeActorByaId()
		System.out.println(service.removeActorByaId(79));

		//removeActorsByIds()
		System.out.println(service.removeActorsByIds(List.of(97, 78)));

		//removeAllActors()
		System.out.println(service.removeAllActors());

		//To recreate the records in database table for future use
		service.registerAllActor(actors);

		System.out.println("*******************End of Execution*********************");

	}

}