package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.ContactDetails;

public interface IContactDetailsJpaRepository extends JpaRepository<ContactDetails, Integer> {

}
