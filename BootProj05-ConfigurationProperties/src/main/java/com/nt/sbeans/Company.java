package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("company")
@Setter
@ToString
@ConfigurationProperties(prefix = "org.nit")
public class Company {

	private String name;
	private String addrs;
	private long pincode;
	private long contact;
}
