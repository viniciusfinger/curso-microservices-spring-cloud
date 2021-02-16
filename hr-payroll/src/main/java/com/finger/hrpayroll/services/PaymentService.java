package com.finger.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finger.hrpayroll.entities.Payment;
import com.finger.hrpayroll.entities.Worker;
import com.finger.hrpayroll.feignClients.WorkerFeignClient;


@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workerFeignClient.findById(workerId).getBody(); 
		
		Payment payment = new Payment();
		payment.setName(worker.getName());
		payment.setDailyIncome(worker.getDailyIncome());
		payment.setDays(days);
		return payment;
	}
}
