package com.db;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * purpose:Retirves all entries form database to java_File
 * */
public class AddressBookDBService {

    private static AddressBookDBService addressBookDBService;

    public static AddressBookDBService getInstance() {
        if (addressBookDBService == null)
            addressBookDBService = new AddressBookDBService();
        return addressBookDBService;
    }

    private AddressBookDBService() {

    }

    /*
     * purpose: connect JDBC connection used:Driver manager class
     */
    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_db";
        String userName = "root";
        String password = "root1999";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!" + connection);
        return connection;
    }

    /*
     * read data from database
     */
    public List<Person> readData() {
        String query = "SELECT * from address_book;";
        return this.getPersonDetailsFromDatabase(query);
    }

    /*
     * getting PersonDetails form Pojo class Person
     */
    private List<Person> getPersonDetailsFromDatabase(String query) {
        List<Person> personList = new ArrayList<Person>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            personList = this.getPersonData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    /*
     * update details of address book by their name
     * */
    public int updateContactNumber(String firstName, String contactNumber) {
        return this.updateAddressBookDataUsingStatement(firstName, contactNumber);
    }

    /*
     * update details of address book by their name
     * update phoneNo of name "pranav"
     * */

    private int updateAddressBookDataUsingStatement(String firstName, String mobileNumber) {
        String sql = String.format("update address_book set mobileNumber = '%s' where firstName = '%s';", mobileNumber, firstName);
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private List<Person> getPersonData(ResultSet resultSet) {

        List<Person> personList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zip = resultSet.getString("zip");
                String mobileNumber = resultSet.getString("mobileNumber");
                String email = resultSet.getString("email");
                personList.add(new Person(id, firstName, lastName, address, city, state, zip, mobileNumber, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;

    }

    //main
    public static void main(String[] args) {

        AddressBookDBService addressBookDBService = new AddressBookDBService();
        List<Person> dataList = addressBookDBService.readData();
        addressBookDBService.updateAddressBookDataUsingStatement("abc", "9999999999");
        System.out.println(dataList);
    }
}