package com.nt.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("bBean")
@Profile("test")
public class BBean {
	public BBean() {
		System.out.println("BBean.test profile");
	}
}
