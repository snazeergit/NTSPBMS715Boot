package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@SpringBootApplication
public class MvcBootProj18BeanNameViewResolverPdfExcelViewExceptionHandlingApplication {

	@Bean
	public BeanNameViewResolver createBeanNameViewResolver() {
		System.out.println("MvcBootProj18BeanNameViewResolverPdfExcelViewApplication.createBeanNameViewResolver()");
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcBootProj18BeanNameViewResolverPdfExcelViewExceptionHandlingApplication.class, args);
	}

}
