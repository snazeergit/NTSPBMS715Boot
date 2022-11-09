package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@SpringBootApplication
public class MvcBootProj17ViewResolversApplication {
	//[Second approach]
	/*
		@Bean
		public ViewResolver createUrlBasedViewResolver() {
			UrlBasedViewResolver resolver = new UrlBasedViewResolver();
			resolver.setSuffix(".jsp");
			resolver.setPrefix("/WEB-INF/pages/");
			resolver.setViewClass(InternalResourceView.class);
			return resolver;
		}*/

	/*@Bean
	public ViewResolver createUrlBasedViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/pages/");
		//Optional to set view class for InternalResourceViewResolver
		//resolver.setViewClass(InternalResourceView.class);
		
		//Mandatory to set view class for all the View classes except InternalResourceViewResolver
		resolver.setViewClass(JstlView.class);
		
		return resolver;
	}*/
	/*
		@Bean
		public ViewResolver createResourceBundleViewResolver() {
			ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
			//optional to specify if the resource bundle name is views.properties
			//resolver.setBasename("views");
			resolver.setBasename("views1");
			return resolver;
		}*/

	public static void main(String[] args) {
		SpringApplication.run(MvcBootProj17ViewResolversApplication.class, args);
	}

}
