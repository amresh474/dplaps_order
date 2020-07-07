package com.dpl.order.filter;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Filters {
	@Bean
	public FilterRegistrationBean someFilterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(someFilter());
		// registration.addUrlPatterns("/url/*");
		// registration.addInitParameter("paramName", "paramValue");
		// registration.setName("someFilter");
		registration.setOrder(1);
		return registration;
	}

	public Filter someFilter() {
		return new AuthFiter();
	}

}
