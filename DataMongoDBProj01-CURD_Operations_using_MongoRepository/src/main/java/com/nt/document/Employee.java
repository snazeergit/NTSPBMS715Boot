package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "EMPLOYEE")
public class Employee {

	@Id
	private String id;
	private Integer eno;
	private String ename;
	private String eadd;
	private Double salary;
	private Boolean isVaccinated;

}
