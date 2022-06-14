package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {

	@Autowired
	@Qualifier("engineAlias")
	private IEngine engine;

	public Vehicle() {
		System.out.println("Vehicle::0-param Constructor");
	}

	public void journey(String startPlace, String destPlace) {
		engine.start();
		System.out.println("Journey started at ::" + startPlace);
		System.out.println("Journey is in progress...");
		engine.stop();
		System.out.println("Journey is stopped at ::" + destPlace);
	}
}
