package com.nt.runners;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Actor;

@Component
public class CallingPL_ProcedureTestRunner implements CommandLineRunner {

	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {

		//create StoredProcedureQuery Object having PL/SQL Procedure name, result type
		StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_ACTORS_BY_CATEGORIES", Actor.class);

		//Register both IN,OUT params of PL/SQL Procedure
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Actor.class, ParameterMode.REF_CURSOR);

		//Set values to IN params
		query.setParameter(1, "Salesman");
		query.setParameter(2, "Manager");

		//Call PL/SQL Procedure
		List<Actor> list = query.getResultList();

		//Process the result
		list.forEach(System.out::println);
	}

}


/*
create or replace PROCEDURE          "P_GET_ACTORS_BY_CATEGORIES" 
(
  ROLE1 IN VARCHAR2 
, ROLE2 IN VARCHAR2 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
open DETAILS for
 SELECT AID,ANAME,CATEGORY,MOBILE_NO FROM ACTOR WHERE CATEGORY IN(role1,role2)ORDER BY CATEGORY;

END P_GET_ACTORS_BY_CATEGORIES;


*/