package com.nt.model;

import java.util.Date;

import lombok.Data;

@Data
public class Customer {

	private Integer cno;
	private String cname;
	private Date dob;
	private Date dop = new Date();
	private Boolean isHavingMembership = false;
}
