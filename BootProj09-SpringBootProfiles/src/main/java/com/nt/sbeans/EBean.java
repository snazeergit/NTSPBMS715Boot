package com.nt.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("eBean")
@Profile("default")
public class EBean {
	public EBean() {
		System.out.println("EBean.default profile");
	}
}
