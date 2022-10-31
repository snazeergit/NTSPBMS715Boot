package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

//Simple Model class nothing to do with any db intereaction
@Data
public class JobSeeker {
	private String jsName;
	private String jsAddrs;
	private MultipartFile resume;
	private MultipartFile photo;
}
