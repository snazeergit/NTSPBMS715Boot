package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "JPA_EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue
	private Integer eno;
	private String ename;
	private String desg;
	private Double salary;

}
