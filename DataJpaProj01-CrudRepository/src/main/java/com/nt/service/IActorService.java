package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Actor;

public interface IActorService {

	public String registerActor(Actor actor);

	public String registerAllActor(List<Actor> actors);

	public long fetchRecordsCount();

	public Iterable<Actor> fetchAllActors();

	public boolean isActorAvailable(int id);

	public Iterable<Actor> fetchActorsByIds(Iterable<Integer> ids);

	public Optional<Actor> fetchActorbyId(int id);

	public Actor showActorById(int id);

	public String updateActorMobileNo(int id, long newMobileNo);

	public String updateActor(Actor actor);

	public String registerOrUpdateActor(Actor actor);

	public String removeActorById(int id);

	public String removeActor(Actor actor);

	public String removeActorByaId(int id);

	public String removeAllActors();

	public String removeActorsByIds(List<Integer> ids);
}