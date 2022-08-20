package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.EmployeeInfo;

public interface IEmployeeInfoRepository extends JpaRepository<EmployeeInfo, Integer> {

}
