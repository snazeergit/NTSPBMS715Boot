package com.nt.service;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
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
		//call the method
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

	@Override
	public String fetchAndUpdateStockDetailsByStokId(int stockId, double newPrice, String newExchangeName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("stockId").is(stockId));
		//Update object for modification
		Update update = new Update();
		update.set("price", newPrice);
		update.set("exchangeName", newExchangeName);
		//call the method
		StockDetails details = template.findAndModify(query, update, StockDetails.class);
		System.out.println(details);
		return details == null ? "stock details doesn't found" : "Stock details found and updated";
	}

	@Override
	public String modifyExchangeByStockPriceRange(double startPrice, double endPrice, String newExchangeName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gte(startPrice).andOperator(Criteria.where("price").lte(endPrice)));
		//Update object for modification
		Update update = new Update().set("exchangeName", newExchangeName);
		//call the method
		UpdateResult result = template.updateMulti(query, update, StockDetails.class);
		return result.getModifiedCount() + " no. of  records are effected";
	}

	@Override
	public String registerOrUpdateStockByStockName(String stockName, double newPrice, String newExchange) {
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));
		//Update object for modification
		Update update = new Update();
		//used for both insertion and updation
		update.set("price", newPrice);
		update.set("exchangeName", newExchange);
		//will be used only for insertion
		update.setOnInsert("stockId", new Random().nextInt(1000));
		update.setOnInsert("stockName", stockName);
		//call the method
		UpdateResult result = template.upsert(query, update, StockDetails.class);
		return result.getModifiedCount() + " no. of records are effected";
	}

	@Override
	public String fetchAndRemoveByStockName(String stockName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));
		StockDetails details = template.findAndRemove(query, StockDetails.class);
		return details == null ? "stock not found" : "stock found and deleted";
	}

	@Override
	public String fetchAllAndRemoveByStockName(String stockName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("stockName").is(stockName));
		int count = template.findAllAndRemove(query, StockDetails.class).size();
		return count + " records deleted";
	}
}
