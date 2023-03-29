package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Person;

public interface IPersonJpaRepository extends JpaRepository<Person, Integer> {

	//@Query("SELECT p.pid, p.pname, p.paddrs, c.regno, c.phoneNo, c.provider, c.type FROM Person p inner join p.contactInfo c ")
	//@Query("SELECT p.pid, p.pname, p.paddrs, c.regno, c.phoneNo, c.provider, c.type FROM Person p right join p.contactInfo c ")
	@Query("SELECT p.pid, p.pname, p.paddrs, c.regno, c.phoneNo, c.provider, c.type FROM Person p left join p.contactInfo c ")
	//@Query("SELECT p.pid, p.pname, p.paddrs, c.regno, c.phoneNo, c.provider, c.type FROM Person p full join p.contactInfo c ")
	public List<Object[]> fetchDataUsingJoinsByParent();
}
