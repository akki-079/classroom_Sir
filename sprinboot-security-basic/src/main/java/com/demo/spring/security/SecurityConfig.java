package com.demo.spring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	DataSource ds;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
		.authorizeHttpRequests()
		.antMatchers("/gethello")
		.permitAll()
		.antMatchers("/posthello")
		.authenticated()
		.and().csrf().disable()
		.httpBasic();
		return http.build();
	}
	
	@Bean
	public JdbcUserDetailsManager userDetailsManager() throws Exception{
		
		JdbcUserDetailsManager userDetails= new JdbcUserDetailsManager(ds);
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
