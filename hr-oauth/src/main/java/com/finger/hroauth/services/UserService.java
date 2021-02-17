package com.finger.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finger.hroauth.entities.User;
import com.finger.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			logger.error("email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		
		logger.info("email found: " + user.getEmail());
		
		return user;
		
	}
	
}
