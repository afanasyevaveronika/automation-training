package com.epam.ta.model;

import java.util.Objects;

public class Booking {
    private String username;
    private String bookingCode;

    public Booking(String username, String bookingCode) {
        this.username = username;
        this.bookingCode = bookingCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "username='" + username + '\'' +
                ", bookingCode='" + bookingCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Booking that = (Booking) obj;
        return  Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getBookingCode(), that.getBookingCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getBookingCode());
    }
}
