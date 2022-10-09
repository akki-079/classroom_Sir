package com.demo.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Dept;
import com.demo.spring.exceptions.DeptNotFoundException;
import com.demo.spring.repositories.DeptRepository;

@RestController
@RequestMapping("/dept")
public class DeptRestController {
	@Autowired
	DeptRepository deptRepository;

	@GetMapping(path = "/{dno}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Dept> findDeptById(@PathVariable("dno") Integer  id) throws DeptNotFoundException {

		Optional<Dept> deptOp = deptRepository.findById(id);
		if (deptOp.isPresent()) {
			return ResponseEntity.ok(deptOp.get());
		} else {
			throw new DeptNotFoundException();
		}

	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dept>> listAll() {
		return ResponseEntity.ok(deptRepository.findAll());
	}
}
