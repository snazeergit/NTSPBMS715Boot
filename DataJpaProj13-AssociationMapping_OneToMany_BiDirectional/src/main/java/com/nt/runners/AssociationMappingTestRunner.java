package com.nt.runners;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IPersonService;

@Component
public class AssociationMappingTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonService service;

	@Override
	public void run(String... args) throws Exception {

		/*//Save object operation (Parent to Child)
		Person person = new Person();
		person.setPname("Nazeer");
		person.setPaddrs("Nellore");
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber_type("Home");
		ph1.setPhone_number(9999L);
		ph1.setProvider("Jio");
		ph1.setPerson(person); //Child to Parent (Many to One)
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber_type("Office");
		ph2.setPhone_number(8888L);
		ph2.setProvider("Airtel");
		ph2.setPerson(person); //Child to Parent (Many to One)
		
		person.setPhones(Set.of(ph1, ph2)); //Parent to Child (One to Many)
		
		try {
			service.saveDataUsingPerson(person);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*//Save object operation (Parent to Child)
		Person person = new Person();
		person.setPname("Sardar");
		person.setPaddrs("Nellore");
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber_type("Home");
		ph1.setPhone_number(7777L);
		ph1.setProvider("Jio");
		ph1.setPerson(person); //Child to Parent (Many to One)
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber_type("Office");
		ph2.setPhone_number(6666L);
		ph2.setProvider("Airtel");
		ph2.setPerson(person); //Child to Parent (Many to One)
		
		Set<PhoneNumber> phoneSet = new HashSet<>();
		phoneSet.add(ph1);
		phoneSet.add(ph2);
		person.setPhones(phoneSet); //Parent to Child (One to Many)
		
		try {
			service.saveDataUsingPhoneNumber(phoneSet);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*service.loadDataUsingParent().forEach(per -> {
			System.out.println("parent::" + per);
			Set<PhoneNumber> child = per.getPhones();
			child.forEach(ph -> {
				System.out.println("Child::" + ph);
			});
		});*/

		service.loadDataUsingChild().forEach(ph -> {
			System.out.println("Child::" + ph);
			//get Associated parent
			Person person = ph.getPerson();
			System.out.println("Parent::" + person);
		});
	}

}
