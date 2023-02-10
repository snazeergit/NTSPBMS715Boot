package com.nt.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("aBean")
@Profile("dev")
public class ABean {
	public ABean() {
		System.out.println("ABean.dev profile ");
	}
}
