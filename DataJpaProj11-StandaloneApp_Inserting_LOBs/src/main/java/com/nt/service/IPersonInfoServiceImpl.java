package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.PersonInfo;
import com.nt.repository.IPersonInfoRepo;

@Service
public class IPersonInfoServiceImpl implements IPersonInfoService {

	@Autowired
	private IPersonInfoRepo repository;

	@Override
	public String registerPerson(PersonInfo info) {
		return repository.save(info).getPid() + " person is saved";
	}

	@Override
	public PersonInfo fetchPersonDetailsById(int pid) {
		return repository.findById(pid).orElseThrow(() -> new IllegalArgumentException("Invalid pid"));
	}

}