package com.nt.service;

import com.nt.entity.PersonInfo;

public interface IPersonInfoService {
	public String registerPerson(PersonInfo info);
	public PersonInfo fetchPersonDetailsById(int pid);
}
