package application.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Time;
import java.util.Objects;

public class Venue {
    private int venueId, capacity;
    private String venueName, address, buildingType;
    @JsonFormat(pattern="HH:mm:ss")
    private Time operationStartTime;
    @JsonFormat(pattern="HH:mm:ss")
    private Time operationEndTime;


    public Venue() {
    }

    public Venue(int venueId, int capacity, String venueName, String address, String buildingType, Time operationStartTime, Time operationEndTime) {
        this.venueId = venueId;
        this.capacity = capacity;
        this.venueName = venueName;
        this.address = address;
        this.buildingType = buildingType;
        this.operationStartTime = operationStartTime;
        this.operationEndTime = operationEndTime;
    }

    public int getVenueId() {
        return this.venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getVenueName() {
        return this.venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuildingType() {
        return this.buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public Time getOperationStartTime() {
        return this.operationStartTime;
    }

    public void setOperationStartTime(Time operationStartTime) {
        this.operationStartTime = operationStartTime;
    }

    public Time getOperationEndTime() {
        return this.operationEndTime;
    }

    public void setOperationEndTime(Time operationEndTime) {
        this.operationEndTime = operationEndTime;
    }

    public Venue venueId(int venueId) {
        this.venueId = venueId;
        return this;
    }

    public Venue capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Venue venueName(String venueName) {
        this.venueName = venueName;
        return this;
    }

    public Venue address(String address) {
        this.address = address;
        return this;
    }

    public Venue buildingType(String buildingType) {
        this.buildingType = buildingType;
        return this;
    }

    public Venue operationStartTime(Time operationStartTime) {
        this.operationStartTime = operationStartTime;
        return this;
    }

    public Venue operationEndTime(Time operationEndTime) {
        this.operationEndTime = operationEndTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Venue)) {
            return false;
        }
        Venue venue = (Venue) o;
        return venueId == venue.venueId && capacity == venue.capacity && Objects.equals(venueName, venue.venueName) && Objects.equals(address, venue.address) && Objects.equals(buildingType, venue.buildingType) && Objects.equals(operationStartTime, venue.operationStartTime) && Objects.equals(operationEndTime, venue.operationEndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venueId, capacity, venueName, address, buildingType, operationStartTime, operationEndTime);
    }

    @Override
    public String toString() {
        return "{" +
            " venueId='" + getVenueId() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", venueName='" + getVenueName() + "'" +
            ", address='" + getAddress() + "'" +
            ", buildingType='" + getBuildingType() + "'" +
            ", operationStartTime='" + getOperationStartTime() + "'" +
            ", operationEndTime='" + getOperationEndTime() + "'" +
            "}";
    }
    
}