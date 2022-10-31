package application.entity;

import java.util.Objects;

public class EmployeeAccount {
    private String username, employeePassword, firstName, lastName;

    public EmployeeAccount() {
    }

    public EmployeeAccount(String username, String employeePassword, String firstName, String lastName) {
        this.username = username;
        this.employeePassword = employeePassword;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmployeePassword() {
        return this.employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
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

    public EmployeeAccount username(String username) {
        this.username = username;
        return this;
    }

    public EmployeeAccount employeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
        return this;
    }

    public EmployeeAccount firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeAccount lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EmployeeAccount)) {
            return false;
        }
        EmployeeAccount employeeAccount = (EmployeeAccount) o;
        return Objects.equals(username, employeeAccount.username) && Objects.equals(employeePassword, employeeAccount.employeePassword) && Objects.equals(firstName, employeeAccount.firstName) && Objects.equals(lastName, employeeAccount.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, employeePassword, firstName, lastName);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", employeePassword='" + getEmployeePassword() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            "}";
    }

}
    