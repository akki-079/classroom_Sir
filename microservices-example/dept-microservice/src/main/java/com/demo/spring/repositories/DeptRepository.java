package com.demo.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.entity.Dept;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

}
