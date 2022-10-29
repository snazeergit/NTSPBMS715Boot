package com.nt;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class MvcBootProj14I18nApplication {

	@Bean(name = "localeResolver") //fied bean id
	public SessionLocaleResolver createSessionLocaleResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en", "US"));
		return resolver;
	}

	@Bean
	public LocaleChangeInterceptor createLocaleChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang"); //default is locale
		return interceptor;
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcBootProj14I18nApplication.class, args);
	}

}
