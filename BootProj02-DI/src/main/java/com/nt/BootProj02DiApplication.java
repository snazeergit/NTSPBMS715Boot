package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
@ImportResource(value = "com/nt/cfgs/applicationContext.xml")
public class BootProj02DiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootProj02DiApplication.class, args);
		Vehicle vehicle = context.getBean("vehicle", Vehicle.class);
		vehicle.journey("Nellore", "Chennai");
		((ConfigurableApplicationContext) context).close();
	}

}
