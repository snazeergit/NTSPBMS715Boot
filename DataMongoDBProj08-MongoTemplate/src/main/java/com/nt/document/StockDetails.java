package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Document(collection = "STOCK_DETAILS")
@AllArgsConstructor
public class StockDetails {

	@Id
	private Integer stockId;
	private String stockName;
	private Double price;
	private String exchangeName;

}
