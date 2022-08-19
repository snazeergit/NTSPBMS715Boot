package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Person_Info_Lob")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PersonInfo implements Serializable {

	@Id
	@GeneratedValue
	private Integer pid;

	@Column(length = 20)
	@NonNull
	private String pname;

	@NonNull
	private LocalDateTime dob;

	@NonNull
	private Boolean married;

	@Lob
	@NonNull
	private byte[] photo;

	@Lob
	@NonNull
	private char[] resume;
}
