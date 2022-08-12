package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IBankService;

@Component
public class TxMgmtTestRunner implements CommandLineRunner {

	@Autowired
	private IBankService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			//try to pass invalid acno(107L) details below to feel rollback operation
			String result = service.transferMoney(101L, 102L, 10000.0);
			System.out.println(result);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
