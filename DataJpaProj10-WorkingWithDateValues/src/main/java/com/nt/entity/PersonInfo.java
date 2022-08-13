package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PersonInfo {

	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length = 20)
	@NonNull
	private String pname;
	@NonNull
	private Float page;
	@NonNull
	private LocalDate DOB;
	@NonNull
	private LocalTime TOB;
	@NonNull
	private LocalDateTime DOJ;

}
