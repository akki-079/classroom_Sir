package com.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entity.EndUser;

public interface EndUserRepository extends JpaRepository<EndUser, String> {

	public EndUser findByUsername(String username);
}
