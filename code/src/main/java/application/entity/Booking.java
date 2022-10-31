package application.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Objects;

public class Booking {
    private int bookingId, venueId, attendeesNumber;
    private String bookingType, username;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp startDateTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp endDateTime;


    public Booking() {
    }

    public Booking(int bookingId, int venueId, int attendeesNumber, String bookingType, String username, Timestamp startDateTime, Timestamp endDateTime) {
        this.bookingId = bookingId;
        this.venueId = venueId;
        this.attendeesNumber = attendeesNumber;
        this.bookingType = bookingType;
        this.username = username;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public int getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getVenueId() {
        return this.venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getAttendeesNumber() {
        return this.attendeesNumber;
    }

    public void setAttendeesNumber(int attendeesNumber) {
        this.attendeesNumber = attendeesNumber;
    }

    public String getBookingType() {
        return this.bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getStartDateTime() {
        return this.startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Timestamp getEndDateTime() {
        return this.endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Booking bookingId(int bookingId) {
        this.bookingId = bookingId;
        return this;
    }

    public Booking venueId(int venueId) {
        this.venueId = venueId;
        return this;
    }

    public Booking attendeesNumber(int attendeesNumber) {
        this.attendeesNumber = attendeesNumber;
        return this;
    }

    public Booking bookingType(String bookingType) {
        this.bookingType = bookingType;
        return this;
    }

    public Booking username(String username) {
        this.username = username;
        return this;
    }

    public Booking startDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
        return this;
    }

    public Booking endDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId && venueId == booking.venueId && attendeesNumber == booking.attendeesNumber && Objects.equals(bookingType, booking.bookingType) && Objects.equals(username, booking.username) && Objects.equals(startDateTime, booking.startDateTime) && Objects.equals(endDateTime, booking.endDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, venueId, attendeesNumber, bookingType, username, startDateTime, endDateTime);
    }

    @Override
    public String toString() {
        return "{" +
            " bookingId='" + getBookingId() + "'" +
            ", venueId='" + getVenueId() + "'" +
            ", attendeesNumber='" + getAttendeesNumber() + "'" +
            ", bookingType='" + getBookingType() + "'" +
            ", username='" + getUsername() + "'" +
            ", startDateTime='" + getStartDateTime() + "'" +
            ", endDateTime='" + getEndDateTime() + "'" +
            "}";
    }
    
}