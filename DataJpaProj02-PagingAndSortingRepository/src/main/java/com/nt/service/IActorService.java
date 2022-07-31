package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Actor;

public interface IActorService {

	public Iterable<Actor> showActorsByOrder(boolean asc, String... properties);

	public Page<Actor> showPageRecords(int pageNo, int pageSize);
	
	public void showActorsByPage(int pageSize);

}