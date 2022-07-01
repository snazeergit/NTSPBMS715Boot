package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj11LayeredAppProfilesSingleYAMLApplication {

	@Autowired
	private Environment env;

	public BootProj11LayeredAppProfilesSingleYAMLApplication() {
		System.out.println(
				"BootProj09LayeredAppProfilesPropertiesFilesApplication.BootProj09LayeredAppProfilesPropertiesFilesApplication()");
	}

	//Reading database details from Properties file using Environment variable
	@Bean(name = "c3p0")
	@Profile("test")
	public ComboPooledDataSource createC3P0DS() throws Exception {
		ComboPooledDataSource c3p0DS = new ComboPooledDataSource();
		c3p0DS.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		c3p0DS.setJdbcUrl(env.getProperty("spring.datasource.url"));
		c3p0DS.setUser(env.getProperty("spring.datasource.username"));
		c3p0DS.setPassword(env.getProperty("spring.datasource.password"));
		c3p0DS.setInitialPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.minSize")));
		c3p0DS.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.maxSize")));
		return c3p0DS;
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProj11LayeredAppProfilesSingleYAMLApplication.class,
				args);
		PayrollOperationsController controller = ctx.getBean("payroll", PayrollOperationsController.class);
		try {
			List<Employee> allEmployeesByDesgs = controller.showAllEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			allEmployeesByDesgs.forEach(emp -> {
				System.out.println(emp);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
