package application.entity;

import java.util.Objects;

public class CustomerAccount{
    private String username, userPassword, firstName, lastName, phoneNumber, emailAddress;

    public CustomerAccount() {
    }

    public CustomerAccount(String username, String userPassword, String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.username = username;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public CustomerAccount username(String username) {
        this.username = username;
        return this;
    }

    public CustomerAccount userPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public CustomerAccount firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerAccount lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerAccount phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerAccount emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CustomerAccount)) {
            return false;
        }
        CustomerAccount customerAccount = (CustomerAccount) o;
        return Objects.equals(username, customerAccount.username) && Objects.equals(userPassword, customerAccount.userPassword) && Objects.equals(firstName, customerAccount.firstName) && Objects.equals(lastName, customerAccount.lastName) && Objects.equals(phoneNumber, customerAccount.phoneNumber) && Objects.equals(emailAddress, customerAccount.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, userPassword, firstName, lastName, phoneNumber, emailAddress);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", userPassword='" + getUserPassword() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", emailAddress='" + getEmailAddress() + "'" +
            "}";
    }


  

}