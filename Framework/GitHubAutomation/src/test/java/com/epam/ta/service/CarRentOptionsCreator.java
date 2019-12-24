package com.epam.ta.service;

import com.epam.ta.model.CarRentOptions;

public class CarRentOptionsCreator {

    public static final String TEST_DATA_CAR_SEARCH_UNAVAILABLE_PICKUPCITY = "testdata.carRentOptions.unavailableCity";
    public static final String TEST_DATA_CAR_SEARCH_PICKUPCITY = "testdata.carRentOptions.pickUpLocation";
    public static final String TEST_DATA_CAR_SEARCH_DROPOFFCITY = "testdata.carRentOptions.dropOffLocation";
    public static final String TEST_DATA_CAR_SEARCH_PICKUPTIME_AFTER_DROPOFFTIME = "testdata.carRentOptions.pickUpTime";
    public static final String TEST_DATA_CAR_SEARCH_DROPOFFTIME_BEFORE_PICKUPTIME = "testdata.carRentOptions.dropOffTime";
    public static final String TEST_DATA_CAR_CLOSED_STORE_DATE = "testdata.carRentOptions.closedDate";
    public static final String TEST_DATA_CAR_SEARCH_PASSED_PICKUPTIME = "testdata.carRentOptions.passedPickUpTime";
    public static final String TEST_DATA_CAR_CLOSED_HOURS_PICKUP = "testdata.carRentOptions.closedPickUpTime";
    public static final String TEST_DATA_CAR_CLOSED_HOURS_DROPOFF = "testdata.carRentOptions.closedDropOffTime";


    public static CarRentOptions withUnavailablePickUpLocation(){
        return new CarRentOptions(TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_UNAVAILABLE_PICKUPCITY));
    }


    public static CarRentOptions withPickUpAndDropOffLocationsInDifferentCountries(){
        return new CarRentOptions(TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PICKUPCITY),
                TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_DROPOFFCITY));
    }


    public static CarRentOptions withDropOffTimeBeforePickUpTime(){
        return new CarRentOptions(TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PICKUPCITY),
                TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PICKUPTIME_AFTER_DROPOFFTIME),
                TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_DROPOFFTIME_BEFORE_PICKUPTIME));
    }


    public static CarRentOptions withPassedPickUpTime(){
        return new CarRentOptions(TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PICKUPCITY),
                TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PASSED_PICKUPTIME),
                TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_DROPOFFTIME_BEFORE_PICKUPTIME));
    }


    public static CarRentOptions withChangingPickUpLocation(){
        return new CarRentOptions(TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PICKUPCITY),
                TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_DROPOFFCITY));
    }

    public static CarRentOptions withEqualPickUpAndDropOffTime(){
        return new CarRentOptions(TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PICKUPCITY),
                TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PICKUPTIME_AFTER_DROPOFFTIME),
                TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PICKUPTIME_AFTER_DROPOFFTIME));
    }

    public static CarRentOptions withClosedRentStores(){
        return new CarRentOptions(TestDataReader.getTestData(TEST_DATA_CAR_SEARCH_PICKUPCITY),
                TestDataReader.getTestData(TEST_DATA_CAR_CLOSED_STORE_DATE),
                TestDataReader.getTestData(TEST_DATA_CAR_CLOSED_HOURS_PICKUP),
                TestDataReader.getTestData(TEST_DATA_CAR_CLOSED_HOURS_DROPOFF));
    }

    public static CarRentOptions withoutRentInformation(){
        return new CarRentOptions();
    }
}
