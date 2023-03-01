package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.ExamResult;

@Component("erProcessor")
public class ExamResultProcessor implements ItemProcessor<ExamResult, ExamResult> {

	public ExamResultProcessor() {
		System.out.println("ExamResultProcessor.ExamResultProcessor()");
	}

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if (item.getPercentage() >= 99.99f)
			return item;
		else
			return null;
	}

}
