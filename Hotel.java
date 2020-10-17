package com.bridgelabz.workshop;

public class Hotel {
	private String name;
	private int weekdayRateForRegularCustomer;
	private int weekendRateForRegularCustomer;
	private int totalPrice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hotel() {
		
	}
	public Hotel(String name, int weekdayRateForRegularCustomer, int weekendRateForRegularCustomer) {
		super();
		this.name = name;
		this.weekdayRateForRegularCustomer = weekdayRateForRegularCustomer;
		this.weekendRateForRegularCustomer = weekendRateForRegularCustomer;
		this.totalPrice=0;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getWeekdayRateForRegularCustomer() {
		return weekdayRateForRegularCustomer;
	}
	public void setWeekdayRateForRegularCustomer(int weekdayRateForRegularCustomer) {
		this.weekdayRateForRegularCustomer = weekdayRateForRegularCustomer;
	}
	public int getWeekendRateForRegularCustomer() {
		return weekendRateForRegularCustomer;
	}
	public void setWeekendRateForRegularCustomer(int weekendRateForRegularCustomer) {
		this.weekendRateForRegularCustomer = weekendRateForRegularCustomer;
	}

}
