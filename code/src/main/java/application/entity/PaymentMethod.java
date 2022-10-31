package application.entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.util.Objects;

public class PaymentMethod {
    private String username, cardNumber, firstName, lastName, cvv, 
                    phoneNumber, addressLineOne, addressLineTwo, postalCode, province, country;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expiryDate;


    public PaymentMethod() {
    }

    public PaymentMethod(String username, String cardNumber, String firstName, String lastName, String cvv,
                         String phoneNumber, String addressLineOne, String addressLineTwo, String postalCode,
                         String province, String country, Date expiryDate) {
        this.username = username;
        this.cardNumber = cardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cvv = cvv;
        this.phoneNumber = phoneNumber;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
        this.expiryDate = expiryDate;
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

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCvv() {
        return this.cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressLineOne() {
        return this.addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return this.addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public PaymentMethod username(String username) {
        this.username = username;
        return this;
    }

    public PaymentMethod cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public PaymentMethod firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PaymentMethod lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PaymentMethod cvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public PaymentMethod phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PaymentMethod addressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
        return this;
    }

    public PaymentMethod addressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
        return this;
    }

    public PaymentMethod postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public PaymentMethod province(String province) {
        this.province = province;
        return this;
    }

    public PaymentMethod country(String country) {
        this.country = country;
        return this;
    }

    public PaymentMethod expiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod paymentMethod = (PaymentMethod) o;
        return Objects.equals(username, paymentMethod.username) && Objects.equals(cardNumber, paymentMethod.cardNumber) && Objects.equals(firstName, paymentMethod.firstName) && Objects.equals(lastName, paymentMethod.lastName) && Objects.equals(cvv, paymentMethod.cvv) && Objects.equals(phoneNumber, paymentMethod.phoneNumber) && Objects.equals(addressLineOne, paymentMethod.addressLineOne) && Objects.equals(addressLineTwo, paymentMethod.addressLineTwo) && Objects.equals(postalCode, paymentMethod.postalCode) && Objects.equals(province, paymentMethod.province) && Objects.equals(country, paymentMethod.country) && Objects.equals(expiryDate, paymentMethod.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, cardNumber, firstName, lastName, cvv, phoneNumber, addressLineOne, addressLineTwo, postalCode, province, country, expiryDate);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", cardNumber='" + getCardNumber() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", cvv='" + getCvv() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", addressLineOne='" + getAddressLineOne() + "'" +
            ", addressLineTwo='" + getAddressLineTwo() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", province='" + getProvince() + "'" +
            ", country='" + getCountry() + "'" +
            ", expiryDate='" + getExpiryDate() + "'" +
            "}";
    }
    
}