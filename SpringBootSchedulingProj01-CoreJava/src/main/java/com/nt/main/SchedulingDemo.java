package com.nt.main;

import java.util.Date;
import java.util.Timer;

import com.nt.job.Task1;

public class SchedulingDemo {
	public static void main(String[] args) {
		System.out.println("SchedulingDemo.main()-start:: App is started at ::" + new Date());
		Timer timer = new Timer();
		/*2000: represents initial delay of 2 sec
		3000: represents gap period*/
		timer.schedule(new Task1(), 2000, 3000);//Period of time
	
		/*year 2022 will be specified as 1900+122=2022; 1900 will auto added to the year index  
		months index starts from 0, jan-0, feb-1, so on*/
		//timer.schedule(new Task1(), new Date(122, 10, 13, 19, 12, 30));//Point of time
		System.out.println("End of main()--App endded at :: "+new Date());
	}
}
