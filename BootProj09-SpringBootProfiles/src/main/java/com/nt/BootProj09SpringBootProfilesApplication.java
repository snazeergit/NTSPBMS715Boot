package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.FBean;

@SpringBootApplication
public class BootProj09SpringBootProfilesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj09SpringBootProfilesApplication.class, args);
		FBean aBean = context.getBean("fBean", FBean.class);
		System.out.println(aBean);
		((ConfigurableApplicationContext) context).close();
	}

}
