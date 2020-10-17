package com.bridgelabz.workshop;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
	public static List<Hotel> hotelList = new ArrayList<>();

	/**
	 * uc1
	 * 
	 */
	public static void addHotelRateAndNameInHotelReservationSystem() {
		Scanner consoleInputObj = new Scanner(System.in);
		while (true) {
			Hotel hotel = new Hotel();
			System.out.println("Enter the name of Hotel");
			hotel.setName(consoleInputObj.next());
			System.out.println("Enter the Rate for Regular Customer");
			hotel.setRateForRegularCustomer(consoleInputObj.nextInt());
			hotelList.add(hotel);
			System.out.println("Do you want to Add more Hotel in the list(Y/N)");
			char choice = consoleInputObj.next().charAt(0);
			if (choice == 'n' || choice == 'N')
				break;
		}
	}

	public static void main(String[] args) {
		addHotelRateAndNameInHotelReservationSystem();
	}
}
