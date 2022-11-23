package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.PlayerInfo;
import com.nt.service.IPlayerService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IPlayerService playerService;

	@Override
	public void run(String... args) throws Exception {
		PlayerInfo pInfo=new PlayerInfo();
		pInfo.setPid(new Random().nextInt(10000));
		pInfo.setPname("Jadeja");
		pInfo.setPaddrs("Sourastra");
		pInfo.setNickNames(List.of("jaddu", "jadu","sir"));
		pInfo.setFriends(new String[] {"Dhoni", "Ashwin"});
		pInfo.setImpKnocks(Map.of("T20 Cup", "30 runs", "IPL", "8 Wickets"));
		pInfo.setMobileNumbers(Set.of(99999999L, 88888888L));
		Properties props=new Properties();
		props.put("Aadhar", "aaaa123");
		props.put("VoterID", "vvvv123");
		pInfo.setIdDetails(props);
		System.out.println("Employee Details:: " + playerService.registerPlayer(pInfo));
	}

}
