package com.finger.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finger.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {}
