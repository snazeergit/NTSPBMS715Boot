package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("customer")
@ConfigurationProperties(prefix = "cust.info")//prefix used in the properties or yml file
@Data
@PropertySource("app.properties")// for custom properties file
public class Customer {

	private Integer custNo;
	private String custName;
	private String custAddrs;
	private Double billAmt;
}


/*If we configure below 3 
1.application.properties(default properties file), 
2.application.yml(default yml file) and 
3.app.properties(customer properties file)
then application.properties will take effect.  */