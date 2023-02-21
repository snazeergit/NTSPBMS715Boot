package com.nt.runners;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.StockDetails;
import com.nt.service.IStockMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {

	@Autowired
	private IStockMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*System.out.println("-----Save Document Operation-----");
		StockDetails details = new StockDetails(new Random().nextInt(1000), "ICICI", 9999d, "BSE");
		System.out.println(service.registerStockDetails(details));*/

		//Bulk/Batch insertion
		/*	System.out.println("-----Bulk/Batch insertion Document Operation-----");
			StockDetails details1 = new StockDetails(new Random().nextInt(1000), "SBI", 7777d, "BSE");
			StockDetails details2 = new StockDetails(new Random().nextInt(1000), "HDFC", 8888d, "BSE");
			StockDetails details3 = new StockDetails(new Random().nextInt(1000), "AXIS", 6677d, "BSE");
			System.out.println(service.registerAllStockDetails(List.of(details1, details2, details3)));*/

		//find operation
		/*service.fetchStockDetailsByExchange("BSE").forEach(System.out::println);
		System.out.println("------------------------------------");
		service.fetchStockDetailsByPriceRange(5000, 8000).forEach(System.out::println);*/

		//findById operation
		/*StockDetails stockDetails = service.fetchStockDetailsByStockId(418);
		System.out.println("Stock Id 418 details: " + stockDetails);*/
		
		//findAndModify operation
		System.out.println(service.fetchAndUpdateStockDetailsByStokId(418, 5555.0, "NSE"));
	}

}
