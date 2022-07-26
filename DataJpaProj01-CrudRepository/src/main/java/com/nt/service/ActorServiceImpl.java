package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service("actorService")
public class ActorServiceImpl implements IActorService {

	//InMemory Proxy Class object that implements Custom reposity interface will be injected 
	@Autowired
	private IActorRepository repository;

	@Override
	public String registerActor(Actor actor) {
		Actor actor2 = repository.save(actor);
		return "Actor is registered with id value" + actor2.getAid();
	}

	@Override
	public String registerAllActor(List<Actor> actors) {
		if (actors.size() != 0) {
			List<Integer> ids = new ArrayList<>();
			Iterable<Actor> actorsList = repository.saveAll(actors);
			for (Actor actor : actorsList) {
				ids.add(actor.getAid());
			}
			return "Actors registered with id numbers" + ids;
		}
		return "Problem in batch insertion";
	}

	@Override
	public long fetchRecordsCount() {
		return repository.count();
	}

	@Override
	public Iterable<Actor> fetchAllActors() {
		Iterable<Actor> actors = repository.findAll();
		return actors;
	}

	@Override
	public Iterable<Actor> fetchActorsByIds(Iterable<Integer> ids) {
		Iterable<Actor> listActors = repository.findAllById(ids);
		return listActors;
	}

	@Override
	public Optional<Actor> fetchActorbyId(int id) {
		Optional<Actor> optional = repository.findById(id);
		return optional;
	}

	@Override
	public Actor showActorById(int id) {
		Optional<Actor> optional = repository.findById(id);
		if (optional.isPresent()) {
			Actor actor = optional.get();
			return actor;
		}
		throw new IllegalArgumentException("No Actor found");
	}

}
