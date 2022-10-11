package com.nt.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service("seasonService")
public class SeasonFinderServiceImpl implements ISeasonFinerService {

	@Override
	public String findSeason() {
		LocalDate ld = LocalDate.now();
		int month = ld.getMonthValue();
		if (month >= 7 && month <= 9)
			return "Rainey Season";
		else if (month >= 3 && month <= 6)
			return "Summer Season";
		else
			return "Winter Season";
	}

}
