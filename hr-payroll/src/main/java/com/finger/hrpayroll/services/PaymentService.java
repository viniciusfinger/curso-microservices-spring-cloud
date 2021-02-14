package com.finger.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.finger.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	public Payment getPayment(long workerId, int days) {
		Payment payment = new Payment();
		payment.setName("Bob");
		payment.setDailyIncome(200.0);
		payment.setDays(days);
		return payment;
	}
}
