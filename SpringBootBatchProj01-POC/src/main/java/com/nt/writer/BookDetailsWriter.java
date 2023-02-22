package com.nt.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("bdWriter")
public class BookDetailsWriter implements ItemWriter<String> {

	public BookDetailsWriter() {
		System.out.println("BookDetailsWriter.BookDetailsWriter()");
	}

	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		System.out.println("BookDetailsWriter.write()");
		chunk.forEach(System.out::println);
	}

}
