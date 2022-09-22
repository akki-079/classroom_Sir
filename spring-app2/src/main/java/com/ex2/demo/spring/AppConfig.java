package com.ex2.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ex2.demo.spring"})
public class AppConfig {

	@Bean
	public String nameBean() {
		return "Peter";
	}
}
