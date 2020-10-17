package com.bridgelabz.workshop;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
			System.out.println("Enter the Weekday Rate for Regular Customer");
			hotel.setWeekdayRateForRegularCustomer(consoleInputObj.nextInt());
			System.out.println("Enter the Weekend Rate for Regular Customer");
			hotel.setWeekendRateForRegularCustomer(consoleInputObj.nextInt());
			hotelList.add(hotel);
			System.out.println("Do you want to Add more Hotel in the list(Y/N)");
			char choice = consoleInputObj.next().charAt(0);
			if (choice == 'n' || choice == 'N')
				break;
		}
	}

	public static void findCheapestHotelGivenDateRange() throws ParseException{
	    	calculateTotalPrice();
	    	Hotel hotelListOfMinimumPrice = hotelList.stream()
					.min((hotel1, hotel2) -> hotel1.getTotalPrice() > hotel2.getTotalPrice() ? 1 : -1).get();
	    	List<Hotel> desiredHotelList = hotelList.stream()
					.filter(hotel -> hotel.getTotalPrice() == hotelListOfMinimumPrice.getTotalPrice()).collect(Collectors.toList());
	    	desiredHotelList.stream().forEach(hotel->System.out.print(hotel.getName()
			+ "   "));
	    	System.out.println("with Total Rates $"+hotelListOfMinimumPrice.getTotalPrice() );
		   
	    }
	public static void  calculateTotalPrice() throws ParseException {
		Scanner scannerObj = new Scanner(System.in);
		System.out.println("Enter the Custome type ");
		String customerType = scannerObj.next();
	    int days[]=getDateFromUserAndReturnDay();
		for (Hotel hotel : hotelList) {
			if (customerType.equals("RegularCustomer")) {
				   for(int index=0;days[index]!=0;index++) {
					   if ((days[index] == 1 ||days[index]  == 7))
							hotel.setTotalPrice(hotel.getTotalPrice() + hotel.getWeekendRateForRegularCustomer());
						else
							hotel.setTotalPrice(hotel.getTotalPrice() + hotel.getWeekdayRateForRegularCustomer());   
				   }
			}
		}
    }
	public static int[] getDateFromUserAndReturnDay() throws ParseException
	{
		int index=0;
		int day[]=new int[10];
		while(true)
		{
		System.out.println("Enter the date in format ddMMMyyyy");
		Scanner consoleInputObj = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();
		String date1 = consoleInputObj.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("ddMMMyyyy");
		Date yourDate = format.parse(date1);
		calendar.setTime(yourDate);
		day[index] = calendar.get(Calendar.DAY_OF_WEEK);
		index++;
		System.out.println("Do you want to stay more day(y/n)");
		char choice=consoleInputObj.next().charAt(0);
		if(choice=='n'||choice=='N')
			break;
		else if(choice=='y'||choice=='Y')
			continue;
		else
		   System.out.println("invalid input");
		}
		return day;
	}
	public static void main(String[] args) throws ParseException {
		addHotelRateAndNameInHotelReservationSystem();
		findCheapestHotelGivenDateRange();
	}
}
