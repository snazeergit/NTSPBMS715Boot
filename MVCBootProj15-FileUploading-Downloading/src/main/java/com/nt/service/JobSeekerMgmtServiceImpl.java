package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IJobSeekerInfoRepository;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {

	@Autowired
	private IJobSeekerInfoRepository jsRepo;

	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
	
		return "Job Seeker is saved with ID value : "+jsRepo.save(info).getJsid();
	}

}
