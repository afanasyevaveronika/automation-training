package by.bsu.framework.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import by.bsu.framework.model.CarRenting;

public class CarRentingCreator {

    public static final DateTimeFormatter DATA_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("h:mm a");
    public static final String TESTDATA_PICK_UP_LOCATION = "testdata.pick_up.location";
    public static final String TESTDATA_RETURN_LOCATION_FAR_AWAY = "testdata.return.location.faraway";
    public static final String TESTDATA_PICK_UP_TIME = "testdata.pick_up.time";
    public static final String TESTDATA_RETURN_TIME = "testdata.return.time";
    public static final String TESTDATA_PICK_UP_TIME_PLACE_CLOSER = "testdata.pick_up.time.place.closer";
    public static final String TESTDATA_RETURN_TIME_PLACE_CLOSER = "testdata.return.time.place.closer";
    public static final String TESTDATA_RETURN_LOCATION_IMPOSSIBLE = "testdata.return.location.impossible";
    public static final String TESTDATA_SAME_TIME = "testdata.sametime";
    public static final String TESTDATA_PICK_UP_LOCATION_TO_CHANGE = "testdata.pick_up.location.to_change";
    public static final String TESTDATA_RETURN_LOCATION = "testdata.return.location";


    public static CarRenting withPickUpLocation() {
        return new CarRenting(TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION), null);
    }

    public static CarRenting withPickUpReturnLocation() {
        return new CarRenting(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                TestDataReader.getTestData(TESTDATA_RETURN_LOCATION_FAR_AWAY),
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_PICK_UP_TIME), TIME_FORMATTER),
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_RETURN_TIME), TIME_FORMATTER));
    }

    public static CarRenting withPickUpReturnLocationAndTime() {
        return new CarRenting(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                TestDataReader.getTestData(TESTDATA_RETURN_LOCATION_FAR_AWAY),
                null, null);
    }

    public static CarRenting withPickUpLocationAndCloserTime() {
        return new CarRenting(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                null,
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_PICK_UP_TIME_PLACE_CLOSER), TIME_FORMATTER),
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_RETURN_TIME_PLACE_CLOSER), TIME_FORMATTER));
    }

    public static CarRenting withPickUpLocationAndSameTime() {
        return new CarRenting(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                null,
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_SAME_TIME), TIME_FORMATTER),
                LocalTime.parse(TestDataReader.getTestData(TESTDATA_SAME_TIME), TIME_FORMATTER));
    }

    public static CarRenting withPickUpReturnImpossibleLocation() {
        return new CarRenting(
                TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION),
                TestDataReader.getTestData(TESTDATA_RETURN_LOCATION_IMPOSSIBLE));
    }

    public static CarRenting withPickUpReturnDifferentLocation() {
        return new CarRenting(TestDataReader.getTestData(TESTDATA_PICK_UP_LOCATION_TO_CHANGE),
                TestDataReader.getTestData(TESTDATA_RETURN_LOCATION));
    }
}