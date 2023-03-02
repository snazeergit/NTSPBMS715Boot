package com.nt.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class IExamResult {
	@Id
	private Integer id;
	private String dob;
	private Float percentage;
	private Integer semester;
}
