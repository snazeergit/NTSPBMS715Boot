package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

	/*Method names formation syntax: findBy<EntityClassPropertyName><Condition>()
		Now aName is the property name and Equals is the condition, findBy is the fixed method prefix
		Its best practise to take first letter of property name in UPPER case, since our property name is aName so the best practise is AName
		so it becomes findByaNameEquals()  [or]  findByANameEquals() */

	//select * from data_jpa_actor where name=?
	public List<Actor> findByaNameEquals(String name);
	//public List<Actor> findByaNameEquals(String name);

	//select * from data_jpa_actor where name=?
	public Iterable<Actor> findByaNameIs(String name);

	//select * from data_jpa_actor where name=?
	public Iterable<Actor> findByaName(String name);

	//select * from data_jpa_actor where aId between ? and ?
	public Iterable<Actor> findByaIdBetween(int start, int end);
	
	//select * from data_jpa_actor where upper(category)=upper(?)
	public Iterable<Actor> findByCategoryEqualsIgnoreCase(String category);
	
	//select * from data_jpa_actor where aName like %?
	//select * from data_jpa_actor where aName like ?%
	//select * from data_jpa_actor where aName like %?%
	public Iterable<Actor> findByaNameLike(String chars);

	//select * from data_jpa_actor where  aName like ?%
	public Iterable<Actor> findByaNameStartingWith(String startChars);
	
	//select * from data_jpa_actor where  aName like %?%
	public Iterable<Actor> findByaNameContainingIgnoreCase(String chars);
	

}