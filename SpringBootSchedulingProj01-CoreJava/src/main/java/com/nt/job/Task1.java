package com.nt.job;

import java.util.Date;
import java.util.TimerTask;

public class Task1 extends TimerTask {

	@Override
	public void run() {
		System.out.println("Sales report on ::" + new Date());

	}

}
