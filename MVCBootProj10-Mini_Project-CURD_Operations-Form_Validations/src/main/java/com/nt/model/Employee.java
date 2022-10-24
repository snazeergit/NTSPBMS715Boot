package com.nt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BOOT_EMP")
public class Employee implements Serializable {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "emp_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer eno;

	@Column(length = 20)
	private String ename;

	@Column(length = 20)
	private String job;
	private Float sal;
	private Integer deptno;
	private String status = "active";
}
