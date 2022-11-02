package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Autowired
	private ServletContext context;

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
		JobSeekerInfo info = new JobSeekerInfo();
		info.setJsName(js.getJsName());
		info.setJsAddrs(js.getJsAddrs());
		info.setResumePath(uploadPath + "/" + filename1);
		info.setPhotoPath(uploadPath + "/" + filename2);

		//use service
		String msg = jsService.registerJobSeeker(info);

		//add the names of the uploaded files to ModelAttribute
		map.put("filename1", filename1);
		map.put("filename2", filename2);
		map.put("resultMsg", msg);

		//return LVN
		return "show_result";
	}

	@GetMapping("/js_report")
	public String showJsReport(Map<String, Object> map) {

		//use service
		List<JobSeekerInfo> jobSeekers = jsService.getAllJobSeekers();
		map.put("jsInfo", jobSeekers);

		//return LVN
		return "report_jobSeeker";
	}

	@GetMapping("js_download")
	public String fileDownload(HttpServletResponse res, @RequestParam("jsId") Integer id, @RequestParam("type") String type)throws Exception{
		//get file path to be downloaded
		String filePath=null;
		if(type.equalsIgnoreCase("resume"))
			filePath=jsService.fetchResumePathByJsId(id);
		else
			filePath=jsService.fetchPhotoPathByJsId(id);
		System.out.println(filePath);
		
		//creating a File object representing file to be downloaded
		File file=new File(filePath);
		//get the length of the file and make it as the respinse content length
		res.setContentLengthLong(file.length());
		//get MIME of th efile and make it as the response content type
		String mimeType=context.getMimeType(filePath);
		 mimeType= mimeType==null?"application/octet-stream":mimeType;
		res.setContentType(mimeType);
		//Creating InputStream pointing to the file
		InputStream is=new FileInputStream(file);
		//create OutputStream pointing to response object
		OutputStream os=res.getOutputStream();
		//instract the browser to give file content as downloadable file
		res.setHeader("Content-Disposition", "attacment;fileName="+file.getName());
		//write file content to response object
		IOUtils.copy(is, os);
		//close strams
		is.close();
		os.close();
		//returning null makes the handler method to send response directly to Browser
		return null;
	}
}
