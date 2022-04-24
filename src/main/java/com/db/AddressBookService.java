package com.db;

import java.util.*;
import com.db.Person;

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
}