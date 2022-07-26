package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Actor;

public interface IActorService {

	public String registerActor(Actor actor);
	public String registerAllActor(List<Actor> actors);
	
	public long fetchRecordsCount();
	public Iterable<Actor> fetchAllActors();
	public Iterable<Actor> fetchActorsByIds(Iterable<Integer> ids);
	public Optional<Actor> fetchActorbyId(int id);
	public Actor showActorById(int id);
	
}