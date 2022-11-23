package com.nt.runner;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.service.IRTOMgmtService;

@Component
public class OneToOneAssociationBidirectionalTestRunner implements CommandLineRunner {

	@Autowired
	private IRTOMgmtService rtoService;

	@Override
	public void run(String... args) throws Exception {

		//save operation
		//parentToChild();
		//childToParent();

		//select operation
		selectChildFromParent();
		selectParentFromChild();

	}

	private void parentToChild() {
		//====  save Object using Parent to Child =========
		//prepare objects 
		//parent
		Person per = new Person();
		per.setPid(new Random().nextInt(10000));
		per.setPname("rajesh");
		per.setPaddrs("hyd");
		//child
		DrivingLicense license = new DrivingLicense();
		license.setLicenseNo(new Random().nextInt(100000));
		license.setLicenseType("LMV");
		license.setExpiryDate(LocalDateTime.of(2042, 10, 23, 14, 20));
		//map the objs
		per.setLicenseDetails(license);

		//save obj
		System.out.println(rtoService.saveDataUsingPerson(per));
	}

	private void childToParent() {
		//====  save Object usingChild  to Parent =========
		//prepare objects 
		//parent
		Person per = new Person();
		per.setPid(new Random().nextInt(10000));
		per.setPname("suresh");
		per.setPaddrs("delhi");
		//child
		DrivingLicense license = new DrivingLicense();
		license.setLicenseNo(new Random().nextInt(100000));
		license.setLicenseType("HMV");
		license.setExpiryDate(LocalDateTime.of(2032, 10, 23, 14, 20));
		//map the objs
		license.setPersonDetails(per);

		//save obj
		System.out.println(rtoService.saveDataUsingDrivingLicense(license));

	}

	private void selectParentFromChild() {
		// =======  select operation using Child===========
		System.out.println("____________________");
		rtoService.showDataUsingDrivingLicense().forEach(license -> {
			System.out.println("Child :" + license);
			Person per = license.getPersonDetails();
			System.out.println("parent ::" + per);
		});

	}

	private void selectChildFromParent() {
		// =======  select operation using Parent===========
		rtoService.showDataUsingPerson().forEach(per -> {
			System.out.println("Parent ::" + per);
			DrivingLicense license = per.getLicenseDetails();
			System.out.println("child ::" + license);
		});
	}

}
