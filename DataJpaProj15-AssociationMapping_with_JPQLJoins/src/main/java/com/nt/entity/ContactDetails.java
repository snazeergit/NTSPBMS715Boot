package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Joins_ContactDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ContactDetails implements Serializable {

	@Id
	@SequenceGenerator(name = "gen1", allocationSize = 10, initialValue = 1000, sequenceName = "SEQ_LANGUAGE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")
	private Integer regno;

	@NonNull
	@Column(length = 20)
	private String phoneNo;
	
	@NonNull
	@Column(length = 20)
	private String type;
	
	@NonNull
	@Column(length = 20)
	private String provider;

	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Per_ID", referencedColumnName = "pid")
	private Person person;
}
