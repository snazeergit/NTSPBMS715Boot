package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.repository.IContactDetailsJpaRepository;
import com.nt.repository.IPersonJpaRepository;

@Service
public class PersonMgmtServiceImpl implements IPersonMgmtService {

	@Autowired
	private IPersonJpaRepository personRepo;
	@Autowired
	private IContactDetailsJpaRepository langRepo;

	@Override
	public List<Object[]> fetchDataByJoinsUsingParent() {

		return personRepo.fetchDataUsingJoinsByParent();
	}

}
