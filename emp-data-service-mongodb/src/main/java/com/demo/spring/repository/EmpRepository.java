package com.demo.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends MongoRepository<Emp, String> {
	@Query("UPDATE Emp e set e.salary=:salary where e.empId=:empId")
	@Transactional
	public int updateSalary(String empId, double salary);
	
	
}
