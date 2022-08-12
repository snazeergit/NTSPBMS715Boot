package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "DATA_JPA_ACCOUNT")
public class Account {

	@Id
	private Long acno;
	private String holdername;
	private Double amount;

}
