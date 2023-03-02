package com.nt.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class OExamResult {
	@Id
	private Integer id;
	private LocalDateTime dob;
	private Float percentage;
	private Integer semester;
}
