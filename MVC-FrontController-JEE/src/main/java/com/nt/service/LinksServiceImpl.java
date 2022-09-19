package com.nt.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class LinksServiceImpl implements ILinksService {

	@Override
	public String generateWishMessage() {
		int hour = LocalDateTime.now().getHour();
		if (hour < 12)
			return "Good Morning";
		else if (hour < 16)
			return "Good Afternoon";
		else if (hour < 20)
			return "Good Evening";
		else
			return "Good Night";
	}

	@Override
	public Set<String> fetchAllLanguages() {
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> langSet = new HashSet<String>();
		for (Locale locale : locales) {
			langSet.add(locale.getDisplayLanguage());
		}
		return langSet;
	}

}
