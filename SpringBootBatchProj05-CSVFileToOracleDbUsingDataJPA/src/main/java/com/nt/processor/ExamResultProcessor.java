package com.nt.processor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.IExamResult;
import com.nt.model.OExamResult;

@Component("erProcessor")
public class ExamResultProcessor implements ItemProcessor<IExamResult, OExamResult> {

	public ExamResultProcessor() {
		System.out.println("ExamResultProcessor.ExamResultProcessor()");
	}

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		if (item.getPercentage() >= 99.99f) {
			OExamResult result = new OExamResult();
			result.setId(item.getId());
			result.setDob(LocalDateTime.parse(item.getDob(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")));
			result.setPercentage(item.getPercentage());
			result.setSemester(item.getSemester());
			return result;
		} else
			return null;
	}

}
