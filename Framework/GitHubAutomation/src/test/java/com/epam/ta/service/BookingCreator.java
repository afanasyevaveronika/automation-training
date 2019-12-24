package com.epam.ta.service;

import com.epam.ta.model.Booking;

public class BookingCreator {

    public static final String TEST_DATA_BOOKING_INCORRECT_USERNAME = "testdata.booking.username";
    public static final String TEST_DATA_BOOKING_INCORRECT_CODE = "testdata.booking.bookingcode";

    public static Booking withIncorrectUsernameAndBookingCode(){
        return new Booking(TestDataReader.getTestData(TEST_DATA_BOOKING_INCORRECT_USERNAME),
                TestDataReader.getTestData(TEST_DATA_BOOKING_INCORRECT_CODE));
    }
}
