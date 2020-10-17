package com.bridgelabz.workshop;

public class Hotel {
	private String name;
	private int rateForRegularCustomer;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRateForRegularCustomer() {
		return rateForRegularCustomer;
	}
	public void setRateForRegularCustomer(int rateForRegularCustomer) {
		this.rateForRegularCustomer = rateForRegularCustomer;
	}
	public Hotel() {
		
	}
	public Hotel(String name, int rateForRegularCustomer) {
		super();
		this.name = name;
		this.rateForRegularCustomer = rateForRegularCustomer;
	}

}
