package com.nt.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class ReportGenerator {

	/*@Scheduled(initialDelay = 2000, fixedDelay = 3000)
	public void generateSalesReport() {
		System.out.println("Sales Report on ::" + new Date());
	}*/

	/*@Scheduled(fixedDelay = 3000)
	public void generateSalesReport() throws InterruptedException {
		System.out.println("Sales Report on ::" + new Date());
		Thread.sleep(5000);
		System.out.println("End of Sales Report::" + new Date());
	}*/
	
	/*@Scheduled(fixedDelay = 3000)
	public void generateSalesReport() throws InterruptedException {
		System.out.println("Sales Report on ::" + new Date());
		Thread.sleep(1000);
		System.out.println("End of Sales Report::" + new Date());
	}*/
	
	/*@Scheduled(fixedDelayString = "3000")
	public void generateSalesReport() throws InterruptedException {
		System.out.println("Sales Report on ::" + new Date());
		Thread.sleep(5000);
		System.out.println("End of Sales Report::" + new Date());
	}*/
	
	@Scheduled(fixedRate = 10000)
	public void generateSalesReport() throws InterruptedException {
		System.out.println("Sales Report on ::" + new Date());
		Thread.sleep(7000);
		System.out.println("End of Sales Report::" + new Date());
	}
	
	/*@Scheduled(fixedRate = 10000)
	public void generateSalesReport() throws InterruptedException {
		System.out.println("Sales Report on ::" + new Date());
		Thread.sleep(15000);
		System.out.println("End of Sales Report::" + new Date());
	}*/
}
