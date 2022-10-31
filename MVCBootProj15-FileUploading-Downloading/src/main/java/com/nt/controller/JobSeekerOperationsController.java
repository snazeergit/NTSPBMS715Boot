package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.model.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

@Controller
public class JobSeekerOperationsController {

	@Autowired
	private IJobSeekerMgmtService jsService;
	@Autowired
	private Environment env;

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}

	@GetMapping("/js_register")
	public String showRegisterJsFormPage(@ModelAttribute("js") JobSeeker js) {
		return "jobseeker_register";
	}

	@PostMapping("/js_register")
	public String registerJsDetails(@ModelAttribute("js") JobSeeker js, Map<String, Object> map) throws Exception {

		String uploadPath = env.getProperty("upload.path");
		//create upload files store folder on the server machine file system if its not already available
		File storeFolder = new File(uploadPath);

		if (!storeFolder.exists()) {
			storeFolder.mkdir();
		}

		//Get Multipart objs representing the uploaded files from Model class obj
		MultipartFile file1 = js.getResume();
		MultipartFile file2 = js.getPhoto();

		//get the inputStream objs pointing to uploaded files contect
		InputStream is1 = file1.getInputStream();
		InputStream is2 = file2.getInputStream();

		//get the names of the uploaded files
		String filename1 = file1.getOriginalFilename();
		String filename2 = file2.getOriginalFilename();
		System.out.println(filename1 + "  " + filename2);

		//create OutputStrams pointing the dest files on server machine file system
		OutputStream os1 = new FileOutputStream(uploadPath + "/" + filename1);
		OutputStream os2 = new FileOutputStream(uploadPath + "/" + filename2);

		//copy uploaded files content(is1,is2) to empty destination files(os1,os2) on server machine file system
		//commons-io-<ver>.jar
		/*IOUtils.copy(is1, os1);
		IOUtils.copy(is2, os2);*/
		//from java9
		is1.transferTo(os1);
		is2.transferTo(os2);

		//close the strams
		is1.close();
		is2.close();
		os1.close();
		os2.close();
		
		//create Entity class obj by collecting data from Model class object
		JobSeekerInfo info=new JobSeekerInfo();
		info.setJsName(js.getJsName());
		info.setJsAddrs(js.getJsAddrs());
		info.setPhotoPath(uploadPath+"/"+filename1);
		info.setResumePath(uploadPath+"/"+filename2);
		
		//use service
		String msg=jsService.registerJobSeeker(info);
		
		//add the names of the uploaded files to ModelAttribute
		map.put("filename1", filename1);
		map.put("filename2", filename2);
		map.put("resultMsg", msg);
		
		//return LVN
		return "show_result";
	}
}
