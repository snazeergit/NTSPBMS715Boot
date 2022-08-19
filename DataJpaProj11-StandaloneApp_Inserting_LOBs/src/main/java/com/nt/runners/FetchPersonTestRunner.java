package com.nt.runners;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonInfoService;

@Component
public class FetchPersonTestRunner implements CommandLineRunner{

	@Autowired
	private IPersonInfoService service;

	@Override
	public void run(String... args) throws Exception {
		//Fetching Person details
		try {
			PersonInfo info1 = service.fetchPersonDetailsById(3);
			if (info1 != null) {
				System.out.println(info1.getPid() + " " + info1.getPname() + " " + info1.getDob());
				
				//Photo retrieved from db table col
				byte[] photoContent1 = info1.getPhoto();
				OutputStream os = new FileOutputStream("NazeerHeadshot.jpg");
				os.write(photoContent1);
				os.flush();
				os.close();
				System.out.println("Photo retrieved from db table col");
				
				//Resume retrieved from db table col
				char[] resumeContent1 = info1.getResume();
				Writer writer = new FileWriter("MyResumeDummy.txt");
				writer.write(resumeContent1);
				writer.flush();
				writer.close();
				System.out.println("Resume retrieved from db table col");
				
			} else {
				System.out.println("Record not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
