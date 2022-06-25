package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("employee")
@ToString
@PropertySource("App.properties")
public class Employee {

	@Value("${org.nit.empName}")
	private String empName;

	@Value("${org.nit.location}")
	private String location;

	@Value("${org.nit.technology}")
	private String technology;

}
