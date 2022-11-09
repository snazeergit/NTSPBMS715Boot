package com.nt.view;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//[Third approach] 
@Component
public class MyMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		System.out.println("MyMvcConfigurer.configureViewResolvers()");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		registry.viewResolver(resolver);
	}
}

/*
 [first approach] : Configuring View Resolver in application.properties only applicable to InternalResourceViewResolver
 [second approach] : Implementing WebMvcConfigurer class and configuring it as a spring bean as shown above
 [third approach] : Configuring ViewResolver class as a spring bean using @Bean method
Note :- If we configure all 3 approaches : second approch will take effect.
  */
