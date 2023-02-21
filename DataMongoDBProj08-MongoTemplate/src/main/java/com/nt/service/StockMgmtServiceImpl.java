package com.nt.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.nt.document.StockDetails;

@Service
public class StockMgmtServiceImpl implements IStockMgmtService {

	@Autowired
	private MongoTemplate template;

	@Override
	public String registerStockDetails(StockDetails details) {

		//given doc obj data will be saved by creating collection called Stock
		int idValue = template.save(details, "Stock").getStockId();

		//given doc obj data will be saved by creating collection with the Document class name
		//int idValue = template.save(details).getStockId();

		//given doc obj data will be saved by creating collection with the Document class name
		//int idValue = template.insert(details).getStockId();

		return "Document is saved with id value:: " + idValue;
	}

	@Override
	public String registerAllStockDetails(List<StockDetails> detailsList) {
		//given doc obj data will be saved by creating collection with the Document class name
		//int count=template.insertAll(detailsList).size();

		//given doc obj data will be saved by creating collection called Stock
		int count = template.insert(detailsList, "Stock").size();

		return count + " records inserted";
	}

	@Override
	public List<StockDetails> fetchStockDetailsByExchange(String exchange) {
		Query query = new Query();
		query.addCriteria(Criteria.where("exchangeName").is(exchange));
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public List<StockDetails> fetchStockDetailsByPriceRange(double startPrice, double endPrice) {
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).lte(endPrice));
		List<StockDetails> list = template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public StockDetails fetchStockDetailsByStockId(int stockId) {
		return template.findById(stockId, StockDetails.class);
		//searches in specified collection "Stock"
		//return template.findById(stockId, StockDetails.class,"Stock");
	}
}
