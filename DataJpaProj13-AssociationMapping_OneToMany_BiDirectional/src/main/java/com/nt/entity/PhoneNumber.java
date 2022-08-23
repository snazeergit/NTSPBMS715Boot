package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PHONE_NUMBERS_OTM")
@Setter
@Getter
public class PhoneNumber {

	@Id
	@GeneratedValue
	private Integer regno;

	private Long phone_number;

	@Column(length = 20)
	private String number_type;

	@Column(length = 20)
	private String provider;

	@ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "PID")
	private Person person;

	public PhoneNumber() {
		System.out.println("PhoneNumber::0-param Constructor" + this.getClass());
	}

}
