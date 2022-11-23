package com.nt.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "PLAYER_INFO")
public class PlayerInfo {

	@Id
	private Integer pid;
	private String pname;
	private String paddrs;
	private List<String> nickNames;
	private Set<Long> mobileNumbers;
	private String[] friends;
	private Map<String, String> impKnocks;
	private Properties idDetails;

}
