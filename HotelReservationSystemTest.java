package com.bridgelabz.workshop;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationSystemTest
{
	
	@Test
	public void givenHotelIsAddedToHotelReservationSystemShouldReturnTrue{
		HotelReservationSystem hotelReservationSystem=new HotelReservationSystem();
		hotelReservationSystem.hotelList.size();
	    Assert.assertEquals(2,hotelReservationSystem.hotelList.size());
	}

}
