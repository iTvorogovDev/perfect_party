package application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Time;
import java.sql.Timestamp;

public class GetUserBookingHistoryResponse {

    private int bookingId;
    private String bookingType;
    private String username;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp startDateTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp endDateTime;
    private int venueId;
    private int attendeesNumber;
    private String venueName;
    private String address;
    private String buildingType;
    private int capacity;
    @JsonFormat(pattern="HH:mm:ss")
    private Time operationStartTime;
    @JsonFormat(pattern="HH:mm:ss")
    private Time operationEndTime;

    public GetUserBookingHistoryResponse(int bookingId, String bookingType, String username, Timestamp startDateTime,
                                         Timestamp endDateTime, int venueId, int attendeesNumber, String venueName,
                                         String address, String buildingType, int capacity, Time operationStartTime,
                                         Time operationEndTime) {
        this.bookingId = bookingId;
        this.bookingType = bookingType;
        this.username = username;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.venueId = venueId;
        this.attendeesNumber = attendeesNumber;
        this.venueName = venueName;
        this.address = address;
        this.buildingType = buildingType;
        this.capacity = capacity;
        this.operationStartTime = operationStartTime;
        this.operationEndTime = operationEndTime;
    }

    public GetUserBookingHistoryResponse() {}

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Timestamp startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Timestamp getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Timestamp endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getAttendeesNumber() {
        return attendeesNumber;
    }

    public void setAttendeesNumber(int attendeesNumber) {
        this.attendeesNumber = attendeesNumber;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Time getOperationStartTime() {
        return operationStartTime;
    }

    public void setOperationStartTime(Time operationStartTime) {
        this.operationStartTime = operationStartTime;
    }

    public Time getOperationEndTime() {
        return operationEndTime;
    }

    public void setOperationEndTime(Time operationEndTime) {
        this.operationEndTime = operationEndTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

}
