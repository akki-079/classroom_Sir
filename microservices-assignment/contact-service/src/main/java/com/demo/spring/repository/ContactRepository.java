package com.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
