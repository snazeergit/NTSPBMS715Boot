package com.nt.runners;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promotions.Offers;
import com.nt.repo.prod.IProductRepo;
import com.nt.repo.promotions.IOffersRepo;

@Component
public class MultiDataSourceTestRunner implements CommandLineRunner {

	@Autowired
	private IProductRepo prodRepo;
	@Autowired
	private IOffersRepo offersRepo;

	@Override
	public void run(String... args) throws Exception {
		//save Product objects
		prodRepo.saveAll(Arrays.asList(new Product("Table", 100.0, 60000.0), new Product("Chair", 200.0, 80000.0),
				new Product("Sofa", 200.0, 70000.0)));
		System.out.println("Products are saved to database");
		System.out.println("=========================");

		//save Offers objects
		offersRepo.saveAll(Arrays.asList(new Offers("Buy1-Get1", "B1G1", 100.0, LocalDateTime.of(2021, 11, 20, 10, 11)),
				new Offers("Buy2-Get1", "B2G1", 200.0, LocalDateTime.of(2021, 11, 20, 10, 11)),
				new Offers("Buy3-Get1", "B3G1", 300.0, LocalDateTime.of(2021, 11, 20, 10, 11))));
		System.out.println("Offers are saved to database");
		System.out.println("=========================");

		System.out.println("=======Display Product Records========");
		prodRepo.findAll().forEach(System.out::println);
		System.out.println("=========================");
		System.out.println("========Display Offers Records=========");
		offersRepo.findAll().forEach(System.out::println);
		System.out.println("=========================");
	}
}
