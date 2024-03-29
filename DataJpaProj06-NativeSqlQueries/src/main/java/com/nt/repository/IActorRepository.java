package com.nt.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Actor;

@Transactional //non-select operation requires this annotation
public interface IActorRepository extends JpaRepository<Actor, Integer> {

	@Query(nativeQuery = true, value = "INSERT INTO ACTOR(AID,ANAME,CATEGORY,MOBILE_NO) VALUES(AID_SEQ.NEXTVAL,?,?,?)")
	@Modifying //non-select operation requires this annotation
	public int insertActor(String name, String role, long mobileNo);

	@Query(nativeQuery = true, value = "SELECT SYSDATE FROM DUAL")
	public Date showDate();

}