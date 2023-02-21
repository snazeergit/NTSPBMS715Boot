package com.nt.service;

import java.util.List;

import com.nt.document.StockDetails;

public interface IStockMgmtService {
	public String registerStockDetails(StockDetails details);
	public String registerAllStockDetails(List<StockDetails> detailsList);
	
	public List<StockDetails> fetchStockDetailsByExchange(String exchange);
	public List<StockDetails> fetchStockDetailsByPriceRange(double startPrice,double endPrice);
	
	public StockDetails fetchStockDetailsByStockId(int stockId);
	public String fetchAndUpdateStockDetailsByStokId(int stockId, double newPrice, String newExchangeName);
}
