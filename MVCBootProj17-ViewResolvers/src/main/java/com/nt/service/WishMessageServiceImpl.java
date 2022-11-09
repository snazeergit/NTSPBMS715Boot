package com.nt.service;

import org.springframework.stereotype.Service;

@Service
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMessage() {

		return "GoodMorning";
	}

}
