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
	private RestTemplate getRestTemplate;
	
	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriParams = new HashMap<>();
		
		uriParams.put("id", "" + workerId);
		
		Worker worker = getRestTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriParams);
		
		Payment payment = new Payment();
		payment.setName(worker.getName());
		payment.setDays(days);
		payment.setDailyIncome(worker.getDailyIncome());
		
		return payment;
	}
}
