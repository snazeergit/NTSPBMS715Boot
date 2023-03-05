package com.nt.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//Entity class to write to DB table records
@Data
@Entity
@Table(name = "EXAM_RESULT")
public class OExamResult {
	@Id
	private Integer id;
	private LocalDateTime dob;
	private Float percentage;
	private Integer semester;
}
