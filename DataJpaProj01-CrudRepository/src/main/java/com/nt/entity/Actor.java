package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "DATA_JPA_ACTOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor//generated parameterized constructor with non-null feild as args only
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACTOR_ID")
	private Integer aid;

	@NonNull
	@Column(name = "ACTOR_NAME", length = 20)
	private String aName;

	@NonNull
	@Column(name = "CATEGORY", length = 20)
	private String category;

	@NonNull
	@Column(name = "MOBILE_NO")
	private Long mobileNo;

}
