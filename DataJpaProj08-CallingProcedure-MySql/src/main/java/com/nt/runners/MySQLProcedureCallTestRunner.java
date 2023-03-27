package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IEmployeeService;

@Component
public class MySQLProcedureCallTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeService service;

	@Override
	public void run(String... args) throws Exception {
		service.fetchEmpByDesg("salesman", "clerk").forEach(System.out::println);
	}

}
/*
CREATE DEFINER=`snazeer`@`%` PROCEDURE `P_GET_EMP_DETAILS_BY_DESG`(IN job1 VARCHAR(10),IN job2 varchar(10))
BEGIN
SELECT ENO,ENAME,DESG,SALARY FROM JPA_EMPLOYEE WHERE DESG IN(job1,job2) ORDER BY DESG;
END
*/