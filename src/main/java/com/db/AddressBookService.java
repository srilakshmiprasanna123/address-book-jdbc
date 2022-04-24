package com.db;

import java.time.LocalDate;
import java.util.*;


public class AddressBookService {

    public enum IOService {DB_IO, REST_IO}
    private List<Person> personList;
    private AddressBookDBService addressBookDBService;

    //constructor
    public AddressBookService() {
        addressBookDBService = AddressBookDBService.getInstance();
    }

    //paramerterised constructor
    public AddressBookService(List<Person> personList) {
        this();
        this.personList = personList;
    }

    /*
     * purpose:checking address book of data equal
     * return @personList
     */
    public List<Person> readAddressBookData(IOService ioService) {
        if (ioService.equals(IOService.DB_IO))
            this.personList = addressBookDBService.readData();
        return personList;
    }

    public void updateContactNumber(String firstName, String mobileNumber) {
        int result = addressBookDBService.updateContactNumber(firstName, mobileNumber);
        if (result == 0) return;
        Person person = this.getAddressBookData(firstName);
        if (person != null)
            person.mobileNumber = mobileNumber;


    }

    public Person getAddressBookData(String firstName) {
        return this.personList.stream()
                .filter(addressBookDataItem -> addressBookDataItem.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
    }

    public boolean checkAddressBookInSyncWithDB(String firstName) {
        List<Person> personList = addressBookDBService.getaddressBookData(firstName);
        return personList.get(0).equals(getAddressBookData(firstName));
    }

    public List<Person> readAddressBookForDateRange(IOService ioService, LocalDate startDate, LocalDate endDate) {
        if (ioService.equals(IOService.DB_IO))
            return addressBookDBService.getAddressBookForDateRange(startDate, endDate);
        return null;
    }
}