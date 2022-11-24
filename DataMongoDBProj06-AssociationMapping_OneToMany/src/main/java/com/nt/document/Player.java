package com.nt.document;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PLAYER_OTM")
public class Player {

	@Id
	private Integer pid;
	private String pname;
	private String country;
	private LocalDateTime dob;

	//Special Property(HAS-A collection)
	private Set<Sport> sportsInfo;
	private Map<String, Medal> medalsInfo;

	@Override
	public String toString() {
		return "Player [pid=" + pid + ", pname=" + pname + ", country=" + country + ", dob=" + dob + ", sportsInfo="
				+ sportsInfo + ", medalsInfo=" + medalsInfo + "]";
	}

}
