package com.nt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Actor;

@Transactional
public interface IActorRepository extends JpaRepository<Actor, Integer> {

	//-------------1. Entity Operation/Query-----------------
	/*
	 @Query(" from Actor where category=?1")
	@Query("from Actor a where a.category=?1")
	@Query("select a from com.nt.entity.Actor a where a.category=?1")
	@Query("from Actor where category=:role")
	public List<Actor> searchActorsByCategory(String role);*/
											//	(or)
	@Query("from Actor where category=:role")
	public List<Actor> searchActorsByCategory(@Param("role") String category);
	
	/*
	 * If the @Query method parameter name is matching with JPQL-HQL query's named parameter name then 
	 * giving @Param is optional while declaring @Query method in the Repository interface.
	 * For this we should enable following setting in Eclipse.
	 */
	
	/*
	//This will sort the result
	@Query("from Actor where mobileNo in(?1,?2,?3,?4)")
	public Iterable<Actor> findActorsByMobileNo(long no1, long no2, long no3,long no4);
	*/
	//This will sort the result by aname
	//@Query(" from Actor where mobileNo in(:no1,:no3,:no2,:no4) order by aname")
	//@Query(" from Actor where mobileNo in(:no1,:no2,:no3,:no4) order by aname")
	//@Query("from Actor where mobileNo in(?1,?2,?3,?4) order by aname")
	@Query("from Actor where mobileNo in(?1,?4,?3,?2) order by aname")
	public Iterable<Actor> findActorsByMobileNo(long no1, long no2, long no3, long no4);

	//------------2. Scalar Operation/Query selecting specific multiple column values-------------------
	@Query("select aid, aname, category from Actor where category in(:cat1,:cat2) order by aname")
	public List<Object[]> findActorsDataByCategories(String cat1, String cat2);

	//-------------3. Scalar Operation/Query selecting specific single column value---------------------
	@Query("select aname from Actor where mobileNo=?1")
	public String findActorNameByMobileNo(long no);

	//--------------4. Executing Multiple Aggregate functions using @Query-----------------
	@Query("select count(*), max(aid), min(aid), sum(aid), avg(aid) from Actor ")
	public Object getActorsAggregateData();

	//--------------5. Executing Sub-Query using @Query------------------------
	@Query("from Actor where aid=(select max(aid) from Actor)")
	public Actor getActorDataByMaxActorId();

	//--------------6. Executing non-select JPQL-HQL queries using @Query and @Modifying methods
	//@Query("update Actor set mobileNo=?1 where aid=2?")
	@Query("update Actor set mobileNo=:newMobileNo where aid=:id")
	@Modifying
	public int updateActorMobileNoByAid(long newMobileNo, int id);

	@Query("delete from Actor where category=:role")
	@Modifying
	public int deleteActorByCategory(String role);

}