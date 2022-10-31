package application.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Objects;

public class MusicEntertainmentOption extends Item {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp availableStartDateTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp availableEndDateTime;

    public MusicEntertainmentOption() {
    }

    public MusicEntertainmentOption(int itemId, int supplierId, String itemType, String itemName, String itemDescription,
                                    double price, Timestamp availableStartDateTime, Timestamp availableEndDateTime) {
        super(itemId, supplierId, itemType, itemName, itemDescription, price);
        this.availableStartDateTime = availableStartDateTime;
        this.availableEndDateTime = availableEndDateTime;
    }

    public Timestamp getAvailableStartDateTime() {
        return this.availableStartDateTime;
    }

    public void setAvailableStartDateTime(Timestamp availableStartDateTime) {
        this.availableStartDateTime = availableStartDateTime;
    }

    public Timestamp getAvailableEndDateTime() {
        return this.availableEndDateTime;
    }

    public void setAvailableEndDateTime(Timestamp availableEndDateTime) {
        this.availableEndDateTime = availableEndDateTime;
    }

    public MusicEntertainmentOption availableStartDateTime(Timestamp availableStartDateTime) {
        this.availableStartDateTime = availableStartDateTime;
        return this;
    }

    public MusicEntertainmentOption availableEndDateTime(Timestamp availableEndDateTime) {
        this.availableEndDateTime = availableEndDateTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MusicEntertainmentOption)) {
            return false;
        }
        MusicEntertainmentOption musicEntertainmentOption = (MusicEntertainmentOption) o;
        return super.equals(musicEntertainmentOption) && Objects.equals(availableStartDateTime, musicEntertainmentOption.availableStartDateTime) && Objects.equals(availableEndDateTime, musicEntertainmentOption.availableEndDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), availableStartDateTime, availableEndDateTime);
    }

    @Override
    public String toString() {
        return "{" +
            super.toString() +
            ", availableStartDateTime='" + getAvailableStartDateTime() + "'" +
            ", availableEndDateTime='" + getAvailableEndDateTime() + "'" +
            "}";
    }
    
}