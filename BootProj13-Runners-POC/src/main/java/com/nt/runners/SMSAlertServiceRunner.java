package com.nt.runners;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SMSAlertServiceRunner implements ApplicationRunner {

	public SMSAlertServiceRunner() {
		System.out.println("SMSAlertServiceRunner.SMSAlertServiceRunner()");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("SMSAlertServiceRunner.run()");
		System.out.println("Non option args : " + args.getNonOptionArgs());
		System.out.println("Option names :  " + args.getOptionNames());
		System.out.println("Option values : +" + args.getOptionValues("key1"));
		System.out.println("Source args : " +Arrays.toString( args.getSourceArgs()));
		System.out.println("________________________________________");
	}

}
