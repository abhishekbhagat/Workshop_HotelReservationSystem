package com.bridgelabz.workshop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
	public static List<Hotel> hotelList = new ArrayList<>();
	public static void addHotelInHotelReservationSystem()  {
		Scanner consoleInputObj = new Scanner(System.in);
		while (true) {
			Hotel hotel = new Hotel();
			System.out.println("Enter the name of Hotel");
			hotel.setName(consoleInputObj.next());
			System.out.println("Enter the Weekday Rate for Regular Customer");
			hotel.setWeekdayRateForRegularCustomer(consoleInputObj.nextInt());
			System.out.println("Enter the Weekend Rate for Regular Customer");
			hotel.setWeekendRateForRegularCustomer(consoleInputObj.nextInt());
			System.out.println("Enter the Weekday Rate for Reward Customer");
			hotel.setWeekdayRateForRewardCustomer(consoleInputObj.nextInt());
			System.out.println("Enter the Weekend Rate for Reward Customer");
			hotel.setWeekendRateForRewardCustomer(consoleInputObj.nextInt());
			System.out.println("Enter the Rating");
			hotel.setRating(consoleInputObj.nextInt());
			hotelList.add(hotel);
			System.out.println("Do you want to Add more Hotel in the list(Y/N)");
			char choice = consoleInputObj.next().charAt(0);
			if (choice == 'n' || choice == 'N')
				break;
		}
	}

	/**
	 * uc11
	 * @throws ParseException
	 * @throws HotelReservationSystemException 
	 */
	public static void findCheapestBestRatedHotelGivenDateRangeForRewardCustomerUsingJavaStream() throws ParseException, HotelReservationSystemException {
		try
		{
			calculateTotalPrice();
			Hotel hotelListOfMinimumPrice = hotelList.stream()
					.min((hotel1, hotel2) -> hotel1.getTotalPrice() > hotel2.getTotalPrice() ? 1 : -1).get();
			Hotel desiredHotelList = hotelList.stream()
					.filter(hotel -> hotel.getTotalPrice() == hotelListOfMinimumPrice.getTotalPrice())
					.max((hotel1, hotel2) -> hotel1.getRating() > hotel2.getRating() ? 1 : -1).get();
			System.out.println(desiredHotelList.getName() + ",Rating:  " + desiredHotelList.getRating()
					+ " and Total prices: $" + desiredHotelList.getTotalPrice());
		}
		catch(HotelReservationSystemException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void calculateTotalPrice() throws ParseException, HotelReservationSystemException {
		Scanner scannerObj = new Scanner(System.in);
		System.out.println("Enter the Custome type ");
		String customerType = scannerObj.next();
		if(!(customerType.equalsIgnoreCase("RewardCustomer") || customerType.equalsIgnoreCase("RegularCustomer")))
				throw new HotelReservationSystemException("You have entered invalid Customer Type");
		int days[] = getDateAndCustomerTypeFromUserAndReturnDay();
		for (Hotel hotel : hotelList) {
			for (int index = 0; days[index] != 0; index++) {
				if ((days[index] == 1 || days[index] == 7)) {
					if (customerType.equals("RegularCustomer"))
						hotel.setTotalPrice(hotel.getTotalPrice() + hotel.getWeekendRateForRegularCustomer());
					else
						hotel.setTotalPrice(hotel.getTotalPrice() + hotel.getWeekendRateForRewardCustomer());
				} else {
					if (customerType.equals("RegularCustomer"))
						hotel.setTotalPrice(hotel.getTotalPrice() + hotel.getWeekdayRateForRegularCustomer());
					else
						hotel.setTotalPrice(hotel.getTotalPrice() + hotel.getWeekdayRateForRewardCustomer());
				}
			}
		}
	}

	public static int[] getDateAndCustomerTypeFromUserAndReturnDay() throws ParseException, HotelReservationSystemException {
		int index = 0;
		int day[] = new int[10];
		while (true) {
			System.out.println("Enter the date in format ddMMMyyyy");
			Scanner consoleInputObj = new Scanner(System.in);
			Calendar calendar = Calendar.getInstance();
			String date1 = consoleInputObj.nextLine();
			SimpleDateFormat format = new SimpleDateFormat("ddMMMyyyy");
			try {
			Date yourDate = format.parse(date1);
			calendar.setTime(yourDate);
			day[index] = calendar.get(Calendar.DAY_OF_WEEK);
			index++;
			System.out.println("Do you want to stay more day(y/n)");
			char choice = consoleInputObj.next().charAt(0);
			if (choice == 'n' || choice == 'N')
				break;
			else if (choice == 'y' || choice == 'Y')
				continue;
			else
				System.out.println("invalid input");
		  }
		 catch (ParseException e) {
		    throw new HotelReservationSystemException("You have entered invalid Date Fomat");
		 }
		}
		return day;
	}

	public static void main(String[] args) throws ParseException, HotelReservationSystemException {
		addHotelInHotelReservationSystem();
		findCheapestBestRatedHotelGivenDateRangeForRewardCustomerUsingJavaStream();
	}
}
