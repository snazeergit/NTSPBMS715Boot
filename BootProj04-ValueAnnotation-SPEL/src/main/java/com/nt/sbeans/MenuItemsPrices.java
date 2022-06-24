package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("menuItems")
public class MenuItemsPrices {

	@Value("${item.dosa}")
	private Integer dosa;
	@Value("${item.idly}")
	private Integer idly;
	@Value("${item.poha}")
	private Integer poha;
	@Value("${item.idiyappam}")
	private Integer idiyappam;
}
