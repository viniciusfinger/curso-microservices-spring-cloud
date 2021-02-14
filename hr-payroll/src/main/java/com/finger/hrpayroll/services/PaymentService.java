package com.finger.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.finger.hrpayroll.entities.Payment;
import com.finger.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap();
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(workerHost + "workers/{id}", Worker.class, uriVariables);
		
		Payment payment = new Payment();
		payment.setName(worker.getName());
		payment.setDailyIncome(worker.getDailyIncome());
		payment.setDays(days);
		return payment;
	}
}
