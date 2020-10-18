package com.bridgelabz.workshop;

public class Hotel {
	private String name;
	private int weekdayRateForRegularCustomer;
	private int weekendRateForRegularCustomer;
	private int totalPrice;
	private int weekdayRateForRewardCustomer;
	private int weekendRateForRewardCustomer;
	private int rating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hotel() {

	}

	public Hotel(String name, int weekdayRateForRegularCustomer, int weekendRateForRegularCustomer,
			int weekdayRateForRewardCustomer, int weekendRateForRewardCustomer, int rating) {
		super();
		this.name = name;
		this.weekdayRateForRegularCustomer = weekdayRateForRegularCustomer;
		this.weekendRateForRegularCustomer = weekendRateForRegularCustomer;
		this.weekdayRateForRewardCustomer = weekdayRateForRewardCustomer;
		this.weekendRateForRewardCustomer = weekendRateForRewardCustomer;
		this.rating = rating;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getWeekdayRateForRewardCustomer() {
		return weekdayRateForRewardCustomer;
	}

	public void setWeekdayRateForRewardCustomer(int weekdayRateForRewardCustomer) {
		this.weekdayRateForRewardCustomer = weekdayRateForRewardCustomer;
	}

	public int getWeekendRateForRewardCustomer() {
		return weekendRateForRewardCustomer;
	}

	public void setWeekendRateForRewardCustomer(int weekendRateForRewardCustomer) {
		this.weekendRateForRewardCustomer = weekendRateForRewardCustomer;
	}

}
