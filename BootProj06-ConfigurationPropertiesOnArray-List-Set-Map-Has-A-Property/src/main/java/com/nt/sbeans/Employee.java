package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties( prefix = "org.nit")//for bulk injections
public class Employee {

	//Simple property
	private Integer eno;
	private String eName;

	//Array type property
	private String[] favColors;

	//Collection type property
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String, Object> idDetails;

	//HAS-A property
	private Company company;

}
