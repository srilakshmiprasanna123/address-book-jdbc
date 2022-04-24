package com.db;

import java.time.LocalDate;

public class Person {
    // variable declaration
    int id;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String mobileNumber;
    String email;
    LocalDate entryDate;

    // paarmeterised constructor
    public Person(int id, String firstName, String lastName, String address, String city, String state, String zip,
                  String mobileNumber, String email, LocalDate entryDate) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.entryDate = entryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    //toString
    @Override
    public String toString() {
        return "Person [lastName=" + lastName + ", address=" + address + ", city=" + city + ", state=" + state
                + ", zip=" + zip + ", mobileNumber=" + mobileNumber + ", email=" + email + ", entryDate=" + entryDate
                + ", id=" + id + ", firstName=" + firstName + "]";
    }
}