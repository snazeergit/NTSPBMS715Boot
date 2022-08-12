package com.nt.service;

public interface IBankService {
	public String transferMoney(Long srcAcno, Long destAcno, Double amount);
}
