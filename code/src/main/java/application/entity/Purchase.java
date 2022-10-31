package application.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.Objects;

public class Purchase {
    private int purchaseId, bookingId;
    private double amount;
    private String username, cardNumber;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date purchaseDate;

    public Purchase() {
    }

    public Purchase(int purchaseId, int bookingId, double amount, String username, String cardNumber, Date purchaseDate) {
        this.purchaseId = purchaseId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.username = username;
        this.cardNumber = cardNumber;
        this.purchaseDate = purchaseDate;
    }

    public int getPurchaseId() {
        return this.purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Purchase purchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
        return this;
    }

    public Purchase bookingId(int bookingId) {
        this.bookingId = bookingId;
        return this;
    }

    public Purchase amount(double amount) {
        this.amount = amount;
        return this;
    }

    public Purchase username(String username) {
        this.username = username;
        return this;
    }

    public Purchase cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public Purchase purchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        return purchaseId == purchase.purchaseId && bookingId == purchase.bookingId && amount == purchase.amount && Objects.equals(username, purchase.username) && Objects.equals(cardNumber, purchase.cardNumber) && Objects.equals(purchaseDate, purchase.purchaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, bookingId, amount, username, cardNumber, purchaseDate);
    }

    @Override
    public String toString() {
        return "{" +
            " purchaseId='" + getPurchaseId() + "'" +
            ", bookingId='" + getBookingId() + "'" +
            ", amount='" + getAmount() + "'" +
            ", username='" + getUsername() + "'" +
            ", cardNumber='" + getCardNumber() + "'" +
            ", purchaseDate='" + getPurchaseDate() + "'" +
            "}";
    }
    
}