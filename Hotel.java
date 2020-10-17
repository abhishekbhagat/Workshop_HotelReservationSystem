package com.bridgelabz.workshop;

public class Hotel {
	private String name;
	private int rateForRegularCustomer;
	private int totalPrice;
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
		this.totalPrice=0;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
