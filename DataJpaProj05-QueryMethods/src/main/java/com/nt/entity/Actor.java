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
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "DATA_JPA_ACTOR")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACTOR_ID")
	private Integer aid;

	@Column(name = "ACTOR_NAME", length = 20)
	@NonNull
	private String aname;

	@Column(name = "CATEGORY", length = 20)
	@NonNull
	private String category;

	@Column(name = "MOBILE_NO")
	@NonNull
	private Long mobileNo;
	
	@Column(name="STATUS", length = 1)
	@NonNull
	private Boolean status;

}
