package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.PersonInfo;
import com.nt.repository.IPersonInfoRepository;

@Service("personService")
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonInfoRepository repository;

	@Override
	public String registerPerson(PersonInfo person) {
		PersonInfo personInfo = repository.save(person);
		return "Person is saved with the id" + personInfo.getPid();
	}

	@Override
	public List<PersonInfo> fetchAllPersons() {
		List<PersonInfo> list = repository.findAll();
		return list;
	}

}
