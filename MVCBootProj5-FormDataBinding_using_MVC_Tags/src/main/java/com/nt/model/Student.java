package com.nt.model;

import lombok.Data;

@Data
public class Student {
	//initialized with some default values to demonstrate the model class obj data binds with form comp as part of two way binding
	private Integer sno=99;
	private String sname="Nazeer";
	private String sadd="Nellore";
	private Float avg=70.0f;
}
