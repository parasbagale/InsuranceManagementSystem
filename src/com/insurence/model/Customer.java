package com.insurence.model;

public class Customer extends Address {

    /**
     * -customerId: int
     * -customerFirstName: String
     * -customerMiddleName: String
     * -customerLastName: String
     * -customerAddress: Address
     * -customerEmail: String
     * -customerDob: String
     * -customerMobileNumber: String
     * */
    private int customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String customerDob;
    private Address address;
    private String email;
    private String customerMobileNumber;
    // constructor

    public Customer() {}

    public Customer(
                    String firstName,
                    String middleName,
                    String lastName,
                    String customerDob,
                    Address address,
                    String email,
                    String customerMobileNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.customerDob = customerDob;
        this.address = address;
        this.email = email;
        this.customerMobileNumber = customerMobileNumber;
    }

    // Getters
    public int getCustomerId() {
        return customerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCustomerDob() {
        return customerDob;
    }
    public Address getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCustomerDob(String customerDob) {
        this.customerDob = customerDob;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }
}
