package com.nt.service;

import java.util.Set;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;

public interface IPersonService {

	public String saveDataUsingPerson(Person per);

	public String saveDataUsingPhoneNumber(Set<PhoneNumber> list);
	
	public Iterable<Person> loadDataUsingParent();
	
	public Iterable<PhoneNumber> loadDataUsingChild();

}
