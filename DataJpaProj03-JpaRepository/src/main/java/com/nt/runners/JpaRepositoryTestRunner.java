package com.nt.runners;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorService;

@Component
public class JpaRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IActorService service;

	@Override
	public void run(String... args) throws Exception {
		//------------------deleteAllByIdInBatch()-------------------
		//	System.out.println("------------------deleteAllByIdInBatch(-)-------------------");
		//	String msg = service.removeActorsByIdsInBatch(List.of(171, 172, 173));
		//	System.out.println(msg);

		//-----------------getReferenceById(-)-----------------
		System.out.println("-----------------getReferenceById(-)------------------");
		try {
			Actor actor = service.searchActorByid(174);
			System.out.println(actor.getClass());
			System.out.println(actor.getAid() + "	" + actor.getAName() + "	" + actor.getMobileNo() + "	"
					+ actor.getCategory());

		} catch (EntityNotFoundException e) {
			System.err.println("Record not found with the given id..");
			e.printStackTrace();
		}

		//-----------------findAll(Example, Sort)-----------------
		System.out.println("-----------------findAll(Example, Sort)-----------------");
		try {
			Actor actor = new Actor("Suresh", "Hero", 999999999L);
			List<Actor> list = service.searchActorsByActor(actor, true, "aName");
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
