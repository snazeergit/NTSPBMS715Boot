package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

	/*Method names formation syntax: findBy<EntityClassPropertyName><Condition>()
	->   if the property name's first letter is in lower case and second is in Upper case then use the property name as it is.
		Now aName is the entity class property and Equals is the condition, findBy is the fixed method prefix
		since our property name is aName so it becomes findByaNameEquals()
		
	->   if the property name's all letter is in lowercase or first word is Lower case and second word first letter is in Upper 
	    then you can use  the property names first letter in upper or  as it is.
		Now category is the entity class property and Equals is the condition, findBy is the fixed method prefix
		since our property name is category so it becomes findBycategoryEquals()	or findByCategoryEquals() */

	//select * from data_jpa_actor where name=?
	public List<Actor> findByAnameEquals(String name);
	//public List<Actor> findByaNameEquals(String name);

	//select * from data_jpa_actor where name=?
	public Iterable<Actor> findByAnameIs(String name);

	//select * from data_jpa_actor where name=?
	public Iterable<Actor> findByAname(String name);

	//select * from data_jpa_actor where aId between ? and ?
	public Iterable<Actor> findByAidBetween(int start, int end);

	//select * from data_jpa_actor where upper(category)=upper(?)
	public Iterable<Actor> findByCategoryEqualsIgnoreCase(String category);

	//select * from data_jpa_actor where aName like %?
	//select * from data_jpa_actor where aName like ?%
	//select * from data_jpa_actor where aName like %?%
	public Iterable<Actor> findByAnameLike(String chars);

	//select * from data_jpa_actor where  aName like ?%
	public Iterable<Actor> findByAnameStartingWith(String startChars);

	//select * from data_jpa_actor where  aName like %?%
	public Iterable<Actor> findByAnameContainingIgnoreCase(String chars);

	//select * from data_jpa_actor where upper(category) in (?,?,?...) order by aName asc
	public Iterable<Actor> findByCategoryInIgnoreCaseOrderByAnameAsc(List<String> categories);

	//select * from data_jpa_actor where aId>=start and aId<=end
	public Iterable<Actor> findByAidGreaterThanEqualAndAidLessThanEqual(int start, int end);
	
	//select * from data_jpa_actor where status=1 or category=?
	//public Iterable<Actor> findByStatusTrueOrCategoryEquals(String category);
	
	//select * from data_jpa_actor where (aId>? and aId<?) or upper(category) not in (?,?,?,.....)
	public Iterable<Actor> findByAidGreaterThanAndAidLessThanOrCategoryNotInIgnoreCase(int start, int end,
			String... categories);

}