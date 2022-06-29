package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03LayeredAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProj03LayeredAppApplication.class, args);
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
