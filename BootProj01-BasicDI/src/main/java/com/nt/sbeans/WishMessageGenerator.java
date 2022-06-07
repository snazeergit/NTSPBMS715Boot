package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	@Autowired
	// HAS-A property
	private LocalDateTime ldt;

	public String generateWishMessage() {
		System.out.println("WishMessageGenerator.generateWishMessage()");
		int hour = ldt.getHour();
		if (hour < 12)
			return "Good Morning";
		else if (hour < 16)
			return "Good Aftrnoon";
		else if (hour < 20)
			return "Good Eveing";
		else
			return "Good NIght";
	}
}
