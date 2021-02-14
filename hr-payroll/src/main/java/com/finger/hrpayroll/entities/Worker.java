package com.finger.hrpayroll.entities;

import java.io.Serializable;

public class Worker implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private Double dailyIncome;
	
	public Worker(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	};
}
