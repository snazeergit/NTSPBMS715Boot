package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aid;

	@Column(length = 20)
	//@NonNull
	private String aname;

	@Column(length = 20)
	//@NonNull
	private String category;

	@Column(unique = true, nullable = true)
	//@NonNull
	private Long mobileNo;

}
