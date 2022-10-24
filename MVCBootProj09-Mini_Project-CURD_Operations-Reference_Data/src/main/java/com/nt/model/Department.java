package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "DEPT")
@Data
public class Department {

	@Id
	private Integer deptno;

	@Column(length = 20)
	private String dname;

	@Column(length = 20)
	private String loc;

}
