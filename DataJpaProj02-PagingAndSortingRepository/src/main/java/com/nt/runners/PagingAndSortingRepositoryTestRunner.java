package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;
import com.nt.service.IActorService;

@Component
public class PagingAndSortingRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IActorService service;

	@Override
	public void run(String... args) throws Exception {
		//true -> ascending order false -> descending order
		service.showActorsByOrder(true, "aid").forEach(System.out::println);
		service.showActorsByOrder(true, "aName", "category").forEach(System.out::println);

		//0 means first page as it follows 0 based index, 3 means fetch 3 records 
		Page<Actor> page = service.showPageRecords(0, 3);
		List<Actor> list = page.getContent();
		System.out.println("===========================");
		System.out.println("Records :: ");
		System.out.println("===========================");
		list.forEach(System.out::println);
		System.out.println("===========================");
		System.out.println("Other info about pages:: ");
		System.out.println("===========================");
		System.out.println("Current page no :: " + page.getNumber());
		System.out.println("Current total pages:: " + page.getTotalPages());
		System.out.println("Total records :: " + page.getTotalElements());
		System.out.println("Is it first page ? " + page.isFirst());
		System.out.println("Is it last page ? " + page.isLast());
		System.out.println("===========================");

		//This will print 3 records per page
		service.showActorsByPage(3);
	}

}
