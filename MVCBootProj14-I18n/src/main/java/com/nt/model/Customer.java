package com.nt.model;

import lombok.Data;

@Data
public class Customer {
	private Integer cno;
	private String cname;
	private String caddress;
	private Float billAmount;
}
