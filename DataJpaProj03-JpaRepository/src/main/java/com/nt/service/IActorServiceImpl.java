package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service
public class IActorServiceImpl implements IActorService {

	@Autowired
	private IActorRepository repository;

	@Override
	public String removeActorsByIdsInBatch(List<Integer> ids) {
		List<Actor> list = repository.findAllById(ids);
		repository.deleteAllByIdInBatch(ids);
		return list.size() + " no of records are deleted in batch";
	}

	@Override
	public Actor searchActorByid(int id) {
		Actor actor = repository.getReferenceById(id);
		return actor;
	}

	@Override
	public List<Actor> searchActorsByActor(Actor actor, boolean order, String... properties) {
		Example<Actor> example = Example.of(actor);
		Sort sort = Sort.by(order ? Direction.ASC : Direction.DESC, properties);
		List<Actor> list = repository.findAll(example, sort);
		return list;
	}
}
