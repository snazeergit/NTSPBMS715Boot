package com.nt.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private IPersonRepository personRepo;

	@Autowired
	private IPhoneNumberRepository phoneRepo;

	@Override
	public String saveDataUsingPerson(Person per) {
		Person person = personRepo.save(per);
		return "Person record has been inserted with ID" + person.getPid();
	}

	@Override
	public String saveDataUsingPhoneNumber(Set<PhoneNumber> list) {
		List<PhoneNumber> list2 = phoneRepo.saveAll(list);
		return list2.size() + " phone numbers are added to the Person record";
	}

}
