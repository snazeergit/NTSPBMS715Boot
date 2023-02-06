package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("hotel")
public class Hotel {

	//direct value injection
	@Value("1234")
	private Integer hotelId;

	//values from properties file
	@Value("${hotel.name}")
	private String hotelName;
	@Value("${customer.name}")
	private String customerName;

	//Spring Expression Language(SPEL) for arithmetic operations
	@Value("#{menuItems.idly+menuItems.dosa}")
	private Float billAmount;

	//Injecting system property keys(keys are fixed)
	@Value("${os.name}")
	private String osName;
	@Value("${user.name}")
	private String windowsUser;

	//Injecting Environmental variables(keys are fixed here too)
	@Value("${Path}")
	private String pathDate;
}
