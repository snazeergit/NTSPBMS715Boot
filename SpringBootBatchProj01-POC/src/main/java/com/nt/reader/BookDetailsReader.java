package com.nt.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component("bdReader")
public class BookDetailsReader implements ItemReader<String> {

	//Source
	String books[] = new String[] { "CRJ", "TIJ", "HFJ", "EJ", "BBJ" };
	int count = 0;

	public BookDetailsReader() {
		System.out.println("BookDetailsReader.BookDetailsReader()");
	}

	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("BookDetailsReader.read()");
		if (count < books.length) {
			return books[count++];
		} else {
			return null;
		}
	}

}
