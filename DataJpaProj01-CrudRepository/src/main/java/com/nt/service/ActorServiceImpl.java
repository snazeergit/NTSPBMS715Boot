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

	//InMemoryProxy Class that implements Custom repository interface's object will be injected 
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
	public boolean isActorAvailable(int id) {
		return repository.existsById(id);
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
		throw new IllegalArgumentException("No Actor found with given id " + id);
	}

	@Override
	public String updateActorMobileNo(int id, long newMobileNo) {
		Optional<Actor> optional = repository.findById(id);
		if (optional.isPresent()) {
			optional.get().setMobileNo(newMobileNo);
			return "Mobile number updated successfully";
		} else {
			return "Actor not found with given id " + id + " for Mobile number updation";
		}
	}

	@Override
	public String updateActor(Actor actor) {
		Actor actor2 = repository.save(actor);
		if (actor2 != null) {
			return "Actor updated successfully";
		} else {
			return "Problem occurred while updating Actor";
		}

	}

	@Override
	public String registerOrUpdateActor(Actor actor) {
		boolean available = repository.existsById(actor.getAid());
		if (available) {
			repository.save(actor);
			return "Actor updated";
		} else {
			repository.save(actor);
			return "Actor registered";
		}
	}

	@Override
	public String removeActorById(int id) {
		boolean available = repository.existsById(id);
		if (available) {
			repository.deleteById(id);
			return "Actor deleted successfully";
		} else {
			return " Actor not available with id " + id + " provided";
		}
	}

	@Override
	public String removeActor(Actor actor) {
		boolean available = repository.existsById(actor.getAid());
		if (available) {
			repository.delete(actor);
			return "Actor deleted successfully";
		} else {
			return " Actor not found";
		}
	}

	@Override
	public String removeActorByaId(int id) {
		Optional<Actor> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return "Actor deleted successfully";
		} else {
			return " Actor not available with id provided";
		}
	}

	@Override
	public String removeAllActors() {
		repository.deleteAll();
		if (repository.count() == 0)
			return "All actors deleted";
		else
			return " All Actors are not deleted";
	}

	@Override
	public String removeActorsByIds(List<Integer> ids) {
				repository.deleteAllById(ids);
			return ids.size()+" actors are deleted";
	
	}

}
