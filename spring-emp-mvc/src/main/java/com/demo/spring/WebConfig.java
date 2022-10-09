package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@ComponentScan(basePackages = { "com.demo.spring" })
@EnableWebMvc
public class WebConfig  implements WebMvcConfigurer{

	 @Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("WEB-INF/");
		vr.setSuffix(".jsp");
		return vr;
	}

	//@Bean
	public ViewResolver viewResolver1() {
		ResourceBundleViewResolver vr = new ResourceBundleViewResolver();
		vr.setBasename("views");
		return vr;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("index").setViewName("index");
		registry.addViewController("finder").setViewName("finder");
		registry.addViewController("register").setViewName("register");
	}
}
