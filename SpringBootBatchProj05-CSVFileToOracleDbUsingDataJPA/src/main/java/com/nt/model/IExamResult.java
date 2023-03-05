package com.nt.model;

import lombok.Data;

//Model class to read form CSV file
@Data
public class IExamResult {
	private Integer id;
	private String dob;
	private Float percentage;
	private Integer semester;
}
