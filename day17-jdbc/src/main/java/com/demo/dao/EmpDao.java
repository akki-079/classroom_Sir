package com.demo.dao;

import java.util.List;

import com.demo.entity.Emp;
import com.demo.exceptions.EmpExistsException;
import com.demo.exceptions.EmpNotFoundException;

public interface EmpDao {

	public Emp findById(Integer id) throws EmpNotFoundException;
	public String save(Emp e) throws EmpExistsException;
	public String delete(Integer id) throws EmpNotFoundException;
	public String update(Emp e) throws EmpNotFoundException;
	public List<Emp> findAll();
}
