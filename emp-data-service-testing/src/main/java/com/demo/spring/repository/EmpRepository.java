<<<<<<< HEAD
package com.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

//its same as DAO, jpa repo has methods 
public interface EmpRepository extends JpaRepository<Emp, Integer> {

	@Query("UPDATE Emp e set e.salary=:salary where empID=:empid")
	@Modifying
	@Transactional
	public int updateSalary(int empid, double salary);

}
=======
package com.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>{

	@Query("UPDATE Emp e set e.salary=:salary where e.empId=:empId")
	@Modifying
	@Transactional
	public int updateSalary(int empId,double salary);
}
>>>>>>> 45987a59c53394b74bc91bb9c1a6a67fef44b04c
