package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("customer")
@ConfigurationProperties(prefix = "cust.info")//prefix used in the properties or yml file
@Data
@PropertySource(value = "classpath:app.properties")// for custom proprties file
public class Customer {

	private Integer custNo;
	private String custName;
	private String custAddrs;
	private Double billAmt;
}