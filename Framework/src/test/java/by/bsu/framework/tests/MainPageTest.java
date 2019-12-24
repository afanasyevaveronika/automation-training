package by.bsu.framework.tests;

import by.bsu.framework.page.MainPage;
import by.bsu.framework.service.CarRentingCreator;
import by.bsu.framework.model.CarRenting;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainPageTest extends CommonConditions {
    private MainPage MainPage = new MainPage(driver);

    @Test
    public void pickupAndReturnAtTheSameMomentImpossible() {
        CarRenting carRenting = CarRentingCreator.withPickUpLocationAndSameTime();
        MainPage.openPage()
                .inputPickUpLocation(carRenting.getPickUpLocation())
                .inputPickUpDate(carRenting.getDateNow().plusDays(2))
                .inputReturnDate(carRenting.getDateNow().plusDays(2))
                .selectPickUpTime(carRenting.getPickUpTime())
                .selectReturnTime(carRenting.getReturnTime())
                .selectCar();
        Assert.assertEquals("Pick-up Date cannot be after Return Date",
                MainPage.getErrorMessage());
    }


    @Test
    public void bookingInImpossibleLocation() {
        CarRenting carRenting = CarRentingCreator.withPickUpReturnImpossibleLocation();
        MainPage.openPage()
                .inputPickUpLocation(carRenting.getPickUpLocation())
                .inputPickUpDate(carRenting.getDateNow().plusDays(1))
                .selectPickUpTime(carRenting.getPickUpTime())
                .selectReturnTime(carRenting.getReturnTime())
                .selectCar();
        Assert.assertEquals("We are unable to process your request at this time." +
                        "Please return to the Homepage and start your process again or use" +
                        "the Worldwide Phone Number List to find your Avis Customer Service telephone number",
                MainPage.getErrorMessage());
    }

    @Test
    public void carRentingForPeriodGreaterThanThirtyDaysOnline() {
        CarRenting carRenting = CarRentingCreator.withPickUpLocation();
        MainPage.openPage()
                .inputPickUpLocation(carRenting.getPickUpLocation())
                .inputPickUpDate(carRenting.getDateNow())
                .inputReturnDate(carRenting.getDateNow().plusDays(35))
                .selectCar();
        Assert.assertEquals("Sorry, Avis doesn´t allow a reservation that is over 30 days to be made online." +
                        "Please call us to complete your booking",
                MainPage.getErrorMessage());
    }

    @Test
    public void carRentingWithoutPickUpLocation() {
        CarRenting carRenting = CarRentingCreator.withPickUpLocation();
        MainPage.openPage()
                .inputPickUpDate(carRenting.getDateNow())
                .inputReturnDate(carRenting.getDateNow().plusDays(3))
                .selectPickUpTime(carRenting.getPickUpTime())
                .selectReturnTime(carRenting.getReturnTime().plusHours(3))
                .selectCar();
        Assert.assertEquals("Please enter a Pick-up Location",
                MainPage.getErrorMessage());
    }

    @Test
    public void carRentingInClosedLocation() {
        CarRenting carRenting = CarRentingCreator.withPickUpLocationAndCloserTime();
        MainPage.openPage()
                .inputPickUpLocation(carRenting.getPickUpLocation())
                .selectPickUpTime(carRenting.getPickUpTime())
                .selectReturnTime(carRenting.getReturnTime())
                .selectCar();
        Assert.assertEquals("The Rental Location you have selected is closed during the hours requested." +
                        "Hours for this location are: Sun-Sat 10:00 AM - 7:00PM Rental by.bsu.framework.service may be available after hours." +
                        "Call: (375) 173-347990 for further details",
                MainPage.getErrorMessage());
    }

    @Test
    public void carRentingForLongDistanseAndShortPeriodOfTime() {
        CarRenting carRenting = CarRentingCreator.withPickUpLocation();
        MainPage.openPage()
                .inputPickUpLocation(carRenting.getPickUpLocation())
                .inputReturnLocation(carRenting.getPickUpLocation())
                .inputPickUpDate(carRenting.getDateNow().plusDays(2))
                .inputReturnDate(carRenting.getDateNow().plusDays(2))
                .selectPickUpTime(carRenting.getPickUpTime())
                .selectReturnTime(carRenting.getReturnTime().plusHours(1))
                .selectCar();
        Assert.assertEquals("The Rental Location you have selected is Sold Out during the dates» requested. Please try another Avis location for renting.",
                MainPage.getErrorMessage());
    }

    @Test
    public void carRentingInFarawayLocations() {
        CarRenting carRenting = CarRentingCreator.withPickUpLocation();
        MainPage.openPage()
                .inputPickUpLocation(carRenting.getPickUpLocation())
                .inputReturnLocation(carRenting.getPickUpLocation())
                .inputPickUpDate(carRenting.getDateNow().plusDays(5))
                .inputReturnDate(carRenting.getDateNow().plusDays(15))
                .selectPickUpTime(carRenting.getPickUpTime().plusHours(1))
                .selectReturnTime(carRenting.getReturnTime().plusHours(1))
                .selectCar();
        Assert.assertEquals("A One-Way Rental between these 2 locations cannot be booked online",
                MainPage.getErrorMessage());
    }

    @Test
    public void pastPickUpTimeCarRenting() {
        CarRenting carRenting = CarRentingCreator.withPickUpLocation();
        MainPage.openPage()
                .inputPickUpLocation(carRenting.getPickUpLocation())
                .inputPickUpDate(carRenting.getDateNow())
                .inputReturnDate(carRenting.getDateNow().plusDays(4))
                .selectPickUpTime(carRenting.getPickUpTime().minusHours(4))
                .selectReturnTime(carRenting.getReturnTime().plusHours(10))
                .selectCar();
        Assert.assertEquals("You selected a date/time prior to the current time",
                MainPage.getErrorMessage());
    }

    @Test
    public void returnTimeGreaterThanPickUpTimeCarRenting() {
        CarRenting bookingCar = CarRentingCreator.withPickUpLocation();
        MainPage.openPage()
                .inputPickUpLocation(bookingCar.getPickUpLocation())
                .inputPickUpDate(bookingCar.getDateNow())
                .inputReturnDate(bookingCar.getDateNow())
                .selectPickUpTime(bookingCar.getPickUpTime().plusHours(4))
                .selectReturnTime(bookingCar.getPickUpTime().plusHours(2))
                .selectCar();
        Assert.assertEquals("Whoops! Your return time has already passed. Please select a new time",
                MainPage.getErrorMessage());
    }

    @Test
    public void carRenting() {
        CarRenting carRenting = CarRentingCreator.withPickUpLocation();
        String bookingInfoPickUpLocation =
                MainPage.carRenting(carRenting).pickUpLocationInfo();
        assertThat(bookingInfoPickUpLocation, is(equalTo(carRenting.getPickUpLocation())));
    }

}