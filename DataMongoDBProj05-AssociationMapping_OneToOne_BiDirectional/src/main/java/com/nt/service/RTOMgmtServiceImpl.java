package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.repository.IDrivingLicenseRepo;
import com.nt.repository.IPersonRepo;

@Service
public class RTOMgmtServiceImpl implements IRTOMgmtService {

	@Autowired
	private IPersonRepo personRepo;
	@Autowired
	private IDrivingLicenseRepo licenseRepo;

	@Override
	public String saveDataUsingPerson(Person person) {
		return "Person with DrivingLicense is saved with ID ::" + personRepo.save(person).getPid();
	}

	@Override
	public String saveDataUsingDrivingLicense(DrivingLicense license) {
		return "Person is saved with DrivingLicense No ::" + licenseRepo.save(license).getLicenseNo();
	}

	@Override
	public List<Person> showDataUsingPerson() {
		return personRepo.findAll();
	}

	@Override
	public List<DrivingLicense> showDataUsingDrivingLicense() {
		return licenseRepo.findAll();
	}

}
