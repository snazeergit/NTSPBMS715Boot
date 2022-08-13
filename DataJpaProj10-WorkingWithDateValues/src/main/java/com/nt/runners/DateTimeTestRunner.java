package com.nt.runners;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonService;

@Component
public class DateTimeTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonService service;

	@Override
	public void run(String... args) throws Exception {
		//Insert operation
		service.registerPerson(new PersonInfo("SARDAR", 28.0f, LocalDate.of(1993, 10, 21), LocalTime.of(16, 30, 52),
				LocalDateTime.of(2019, 05, 05, 10, 30)));

		//select operation
		service.fetchAllPersons().forEach(System.out::println);
	}

}
