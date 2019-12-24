package com.epam.ta.test;

import com.epam.ta.model.CarRentOptions;
import com.epam.ta.page.HomePage;
import com.epam.ta.service.CarRentOptionsCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.epam.ta.util.StringUtils.*;

public class CarRentTest extends CommonConditions {

    @Test(description = "Test for renting a car in the unavailable city")
    public void rentCarInUnavailableCityTest() {
        CarRentOptions testCarOptions = CarRentOptionsCreator.withUnavailablePickUpLocation();
        String errorMessage = new HomePage(driver)
                .openPage()
                .inputUnavailablePickUpLocation(testCarOptions)
                .getErrorMessage();
        Assert.assertEquals(UNAVAILABLE_PICKUP_LOCATION_ERROR_MESSAGE, errorMessage);
    }


    @Test(description = "Test for searching cars with drop-off time before pick-up time")
    public void searchCarWithDropOffTimeBeforePickUpTimeTest() {
        CarRentOptions testCarOptions = CarRentOptionsCreator.withDropOffTimeBeforePickUpTime();
        String errorMessage = new HomePage(driver)
                .openPage()
                .checkPickUpAndDropOffTime(testCarOptions);
        Assert.assertEquals(DROPOFF_TIME_ERROR_MESSAGE, errorMessage);
    }


    @Test(description = "Test for renting a car in different countries")
    public void rentCarInDifferentCountriesTest() {
        CarRentOptions testCarOptions = CarRentOptionsCreator.withPickUpAndDropOffLocationsInDifferentCountries();
        String errorMessage = new HomePage(driver)
                .openPage()
                .inputLocationInformation(testCarOptions)
                .getLocationErrorMessage();
        Assert.assertEquals(PICKUP_AND_DROPOFF_LOCATION_ERROR_MESSAGE, errorMessage);
    }


    @Test(description = "Test for searching cars with passed pick-up time")
    public void searchCarWithPassedPickUpTimeTest() {
        CarRentOptions testCarOptions = CarRentOptionsCreator.withPassedPickUpTime();
        String errorMessage = new HomePage(driver)
                .openPage()
                .checkPickUpTime(testCarOptions);
        Assert.assertEquals(PASSED_PICKUP_TIME_ERROR_MESSAGE, errorMessage);
    }


    @Test(description = "Test for searching cars with the same pick-up and drop-off time")
    public void searchCarWithEqualPickUpAndDropOffTimeTest() {
        CarRentOptions testCarOptions = CarRentOptionsCreator.withEqualPickUpAndDropOffTime();
        String errorMessage = new HomePage(driver)
                .openPage()
                .checkEqualPickUpAndDropOffTime(testCarOptions);
        Assert.assertEquals(EQUAL_PICKUP_AND_DROPOFF_TIME_MESSAGE, errorMessage);
    }


    @Test(description = "Test for searching cars with empty search form")
    public void searchCarWithEmptySearchFormTest() {
        CarRentOptions testCarOptions = CarRentOptionsCreator.withoutRentInformation();
        String errorMessage = new HomePage(driver)
                .openPage()
                .leaveSearchFormEmpty(testCarOptions);
        Assert.assertEquals(EMPTY_SEARCH_FORM_ERROR_MESSAGE, errorMessage);
    }


    @Test(description = "Test for checking possibility to change pick-up location on the payment page")
    public void changePickUpLocaionOnPaymentPageTest() {
        CarRentOptions testCarOptions = CarRentOptionsCreator.withChangingPickUpLocation();
        String message = new HomePage(driver)
                .openPage()
                .inputLocationInformation(testCarOptions)
                .getLocationErrorMessage();
        Assert.assertEquals(PICKUP_AND_DROPOFF_LOCATION_ERROR_MESSAGE, message);
    }


    @Test(description = "Test for searching cars if the rental stores are closed at the requested time")
    public void searchCarInStoresAtNonworkingTimeTest() {
        CarRentOptions testCarOptions = CarRentOptionsCreator.withClosedRentStores();
        String errorMessage = new HomePage(driver)
                .openPage()
                .searchCarInClosedHours(testCarOptions)
                .getClosedStoresErrorMessage();
        Assert.assertEquals(CLOSED_STORES_ERROR_MESSAGE, errorMessage);
    }
}
