package com.nt.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "LICENSE_OTO")
public class DrivingLicense {

	@Id
	@NonNull
	private Integer licenseNo;
	@NonNull
	private String licenseType;
	@NonNull
	private LocalDateTime expiryDate;
	private Person personDetails;

	@Override
	public String toString() {
		return "DrivingLicense [licenseNo=" + licenseNo + ", type=" + licenseType + ", expiryTime=" + expiryDate + "]";
	}

}
