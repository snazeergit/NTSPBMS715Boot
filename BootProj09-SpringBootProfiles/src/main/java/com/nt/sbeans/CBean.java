package com.nt.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("cBean")
@Profile("uat")
public class CBean {
	public CBean() {
		System.out.println("CBean.uat profile");
	}
}
