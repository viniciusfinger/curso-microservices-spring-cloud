package com.finger.hrworker.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finger.hrworker.entities.Worker;
import com.finger.hrworker.repositories.WorkerRepository;


@RestController
@RequestMapping("/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository repository;
	
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
}