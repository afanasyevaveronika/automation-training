package com.epam.ta.model;

import java.util.Objects;

public class CarRentOptions {
    private String pickUpLocation;
    private String dropOffLocation;
    private String pickUpdate;
    private String dropOffDate;
    private String pickUpTime;
    private String dropOffTime;


    public CarRentOptions(String pickUpLocation, String dropOffLocation, String pickUpdate, String dropOffDate, String pickUpTime, String dropOffTime) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.pickUpdate = pickUpdate;
        this.dropOffDate = dropOffDate;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
    }

    public CarRentOptions(String pickUpLocation, String dropOffDate, String pickUpTime, String dropOffTime) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffDate = dropOffDate;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
    }

    public CarRentOptions(String pickUpLocation, String pickUpTime, String dropOffTime) {
        this.pickUpLocation = pickUpLocation;
        this.pickUpTime = pickUpTime;
        this.dropOffTime = dropOffTime;
    }

    public CarRentOptions(String pickUpLocation, String dropOffLocation) {
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }


    public CarRentOptions(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public CarRentOptions() {}

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public void setPickUpdate(String pickUpdate) {
        this.pickUpdate = pickUpdate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setDropOffTime(String dropOffTime) {
        this.dropOffTime = dropOffTime;
    }


    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public String getPickUpdate() {
        return pickUpdate;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }


    @Override
    public String toString() {
        return "CarRentOptions{" +
                "pickUpLocation='" + pickUpLocation + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                ", pickUpdate='" + pickUpdate + '\'' +
                ", dropOffDate='" + dropOffDate + '\'' +
                ", pickUpTime='" + pickUpTime + '\'' +
                ", dropOffTime='" + dropOffTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CarRentOptions that = (CarRentOptions) obj;
        return  Objects.equals(getPickUpLocation(), that.getPickUpLocation()) &&
                Objects.equals(getDropOffLocation(), that.getDropOffLocation()) &&
                Objects.equals(getPickUpdate(), that.getPickUpdate()) &&
                Objects.equals(getDropOffDate(), that.getDropOffDate()) &&
                Objects.equals(getPickUpTime(), that.getPickUpTime()) &&
                Objects.equals(getDropOffTime(), that.getDropOffTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPickUpLocation(), getDropOffLocation(), getPickUpdate(), getDropOffDate(), getPickUpTime(), getDropOffTime());
    }
}
