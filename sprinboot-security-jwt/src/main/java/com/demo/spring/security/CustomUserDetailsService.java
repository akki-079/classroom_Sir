package com.demo.spring.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.EndUser;
import com.demo.spring.repository.EndUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	EndUserRepository endUserRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("User Loaded from database");
		EndUser endUser = endUserRepo.findByUsername(username);
		return new User(endUser.getUsername(), endUser.getPassword(), new ArrayList<>());
		
	}

}
