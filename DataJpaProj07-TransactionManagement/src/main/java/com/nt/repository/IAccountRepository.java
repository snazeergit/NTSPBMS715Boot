package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {

	//Positional parameters
	//@Query(nativeQuery = true, value = "update Account set amount=amount-? where acno=?")

	//Ordinal Positional parameters
	//@Query(nativeQuery = true, value = "update Account set amount=amount-?1 where acno=?2")

	//Named parameters
	@Query("update Account set amount=amount-:amt where acno=:srcAcno")
	@Modifying
	public int withdrawMoney(Long srcAcno, Double amt);

	//Positional parameters
	//@Query(nativeQuery = true, value = "update Account set amount=amount+? where acno=?")

	//Ordinal Positional parameters
	//@Query(nativeQuery = true, value = "update Account set amount=amount+?1 where acno=?2")

	//Named parameters
	@Query("update Account set amount=amount+:amt where acno=:srcAcno")
	@Modifying
	public int depositMoney(Long srcAcno, Double amt);
}
