package com.nt.document;

import java.time.LocalDateTime;

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
@Document(collection = "MEDALS_DETAILS")
public class Medal {

	@Id
	private Integer mid;
	private String medalType;
	private String eventName;
	private LocalDateTime medalDate;

	@Override
	public String toString() {
		return "Medal [mid=" + mid + ", medalType=" + medalType + ", eventName=" + eventName + ", medalDate="
				+ medalDate + "]";
	}

}
