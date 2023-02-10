package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("fBean")

public class FBean {
	public FBean() {
		System.out.println("FBean.no profile");
	}
}
