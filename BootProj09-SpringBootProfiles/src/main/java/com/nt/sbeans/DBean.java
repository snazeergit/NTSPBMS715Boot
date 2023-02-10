package com.nt.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dBean")
@Profile("prod")
public class DBean {
	public DBean() {
		System.out.println("DBean.prod profile");
	}
}
