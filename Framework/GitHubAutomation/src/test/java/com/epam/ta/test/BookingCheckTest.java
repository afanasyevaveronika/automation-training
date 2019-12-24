package com.epam.ta.test;

import com.epam.ta.model.Booking;
import com.epam.ta.page.HomePage;
import com.epam.ta.service.BookingCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.ta.util.StringUtils.BOOKING_ERROR_MESSAGE;

public class BookingCheckTest extends CommonConditions {

    @Test(description = "Test for checking bookings with incorrect username and booking code")
    public void logInWithIncorrectUsernameAndPasswordTest() {
        Booking bookingInformation = BookingCreator.withIncorrectUsernameAndBookingCode();
        String errorMessage = new HomePage(driver)
                .openPage()
                .redirectToBookingPage()
                .getErrorMessage(bookingInformation);
        Assert.assertEquals(BOOKING_ERROR_MESSAGE, errorMessage);
    }
}
