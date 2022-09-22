package com.demo.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeRequests().antMatchers("/find/**").hasRole("USER").antMatchers("/list").permitAll()
				.antMatchers("/save").hasRole("ADMIN").and().httpBasic().and().csrf().disable().build();
	}

	@Autowired
	public void mycredentialStoreConfig(AuthenticationManagerBuilder authBuilder) throws Throwable {
		authBuilder.inMemoryAuthentication().withUser("john").password("welcome1").roles("USER", "ADMIN");
		authBuilder.inMemoryAuthentication().withUser("peter").password("welcome1").roles("ADMIN");
		authBuilder.inMemoryAuthentication().withUser("jenny").password("welcome1").roles("USER").disabled(true);

	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
