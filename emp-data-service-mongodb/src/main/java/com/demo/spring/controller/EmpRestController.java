package com.demo.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;
import com.demo.spring.util.Message;

@RestController
public class EmpRestController {

	@Autowired
	private EmpRepository empRepo;

	@GetMapping(path = "/find/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findOneEmp(@PathVariable("empId") String id) {
		System.out.println(empRepo.getClass().getName());
		Optional<Emp> empOp = empRepo.findById(id);
		if (empOp.isPresent()) {
			return ResponseEntity.ok(empOp.get());
		} else {
			return ResponseEntity.ok(new Message("Emp Not Found.."));
		}
	}
	
	
	@RequestMapping(path = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> save(@RequestBody Emp e) {

		if (empRepo.existsById(e.getEmpId())) {
			return ResponseEntity.ok(new Message("Emp Exists.."));
		} else {
			empRepo.save(e);
			return ResponseEntity.ok(new Message("Emp Saved.."));
		}
	}

	@PatchMapping(path = "/update/{empId}/{salary}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updateSalary(@PathVariable("empId") String id, @PathVariable("salary") double sal) {

		Optional<Emp> empOp = empRepo.findById(id);
		if (empOp.isPresent()) {
			empRepo.updateSalary(id, sal);
			return ResponseEntity.ok(new Message("Salary Updated"));
		} else {
			return ResponseEntity.ok(new Message("Emp Does not exist"));
		}
	}
}
