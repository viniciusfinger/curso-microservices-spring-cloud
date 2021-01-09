package com.finger.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finger.hrworker.entities.Worker;
import com.finger.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	@Autowired
	WorkerRepository workerRepository;
	
	@GetMapping()
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok().body(workers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker worker = workerRepository.findById(id).orElse(null);
		return ResponseEntity.ok().body(worker);
	}
}