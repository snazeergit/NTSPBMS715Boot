package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.repository.IAccountRepository;

@Service("bankService")
public class BankServiceImpl implements IBankService {

	@Autowired
	private IAccountRepository repository;

	@Override
	@Transactional //mandatory as its dealing with multiple persistence operations
	public String transferMoney(Long srcAcno, Long destAcno, Double amount) {
		int withdrawMoney = repository.withdrawMoney(srcAcno, amount);
		int depositMoney = repository.depositMoney(destAcno, amount);
		if (withdrawMoney == 0 || depositMoney == 0) {
			throw new RuntimeException("Problem occurred, Money Transfer operation is aborted");//must be unchecked exception
		}
		return "**************Rs " + amount + " INR money transfered from account no " + srcAcno + " to " + depositMoney
				+ "successfully.***************";
	}

}
