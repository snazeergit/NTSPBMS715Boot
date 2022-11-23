package com.nt.service;

import java.util.List;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;

public interface IRTOMgmtService {

	public String saveDataUsingPerson(Person person);

	public String saveDataUsingDrivingLicense(DrivingLicense license);

	public List<Person> showDataUsingPerson();

	public List<DrivingLicense> showDataUsingDrivingLicense();

}
