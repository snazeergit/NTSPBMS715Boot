package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Service("actorService")
public class ActorServiceImpl implements IActorService {

	// InMemoryProxy Class object that implements Custom repository interface will
	// be injected
	@Autowired
	private IActorRepository repository;

	@Override
	public Iterable<Actor> showActorsByOrder(boolean asc, String... properties) { // based on property sorting happens
		// True->ascending False->Descending order
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		// get records by applying sorting
		Iterable<Actor> iterable = repository.findAll(sort);
		return iterable;
	}

	@Override
	public Page<Actor> showPageRecords(int pageNo, int pageSize) {
		PageRequest pageRequest = null;
		// Page<Actor> pages = null;
		// pageNo zero-based page index, must not be negative.
		// pageSize the size of the page to be returned, must be greater than 0.
		if (pageNo >= 0 & pageSize > 0)
			pageRequest = PageRequest.of(pageNo, pageSize);
		if (pageRequest != null)
			return repository.findAll(pageRequest);
		throw new IllegalArgumentException("PageRequest can not be null: " + pageRequest);
	}

	@Override
	public void showActorsByPage(int pageSize) {
		long recordsCount = repository.count();
		long pagesCount = recordsCount / pageSize;
		pagesCount = (recordsCount % pageSize == 0) ? pagesCount : ++pagesCount;

		for (int i = 0; i < pagesCount; i++) {
			System.out.println("Page " + (i + 1) + " records ::");
			PageRequest pageRequest = PageRequest.of(i, pageSize);
			Page<Actor> pages = repository.findAll(pageRequest);
			pages.getContent().forEach(System.out::println);
		}
	}

}
