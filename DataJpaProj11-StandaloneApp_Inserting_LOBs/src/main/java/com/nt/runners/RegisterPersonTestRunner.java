package com.nt.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonInfoService;

//@Component
public class RegisterPersonTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonInfoService service;

	@Override
	public void run(String... args) throws Exception {

		//Setting input
		String name = "Nazeer";
		String dob = "1991-01-18T10:23:10";
		boolean isMarried = true;
		String photoPath = "C:\\Home\\NazeerHeadshot.jpg";
		String resumePath = "C:\\Home\\MyResumeDummy.txt";

		//Converting String data 
		LocalDateTime ldt = LocalDateTime.parse(dob);

		//Prepare byte[] from the photo file content
		File file1 = new File(photoPath);
		FileInputStream fis = new FileInputStream(file1);
		byte[] photoContent = new byte[(int) file1.length()];
		fis.read(photoContent);
		fis.close();

		//Prepare char[] from the resume file content
		File file2 = new File(resumePath);
		FileReader reader = new FileReader(file2);
		char[] resumeContent = new char[(int) file2.length()];
		reader.read(resumeContent);
		reader.close();

		//Create Entity class object
		PersonInfo info = new PersonInfo(name, ldt, isMarried, photoContent, resumeContent);

		//save the object
		try {
			service.registerPerson(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
