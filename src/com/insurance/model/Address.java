package com.insurance.model;

public class Address {
    private int buildingNumber;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address() {
    }

    public Address(int buildingNumber, String street, String city, String state, String country, String zipCode) {
        this.buildingNumber = buildingNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Address(String address) {
        setAddress(address);
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }
    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
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
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public void setAddress(String strAddress) {
        // 1 Belmont Ave, San Francisco, OH 44555, USA
        //      0           1               2       3
        String[] addressArr = strAddress.split(",");
        String[] houseAddress = addressArr[0].split(" ");
        int houseNum = Integer.parseInt( houseAddress[0]);

        String street = "";
        for (int i = 1; i < houseAddress.length; i++)
        {
            street += houseAddress[i];
        }
        String city = addressArr[1].strip();

        String[] stateZipArr = addressArr[2].strip().split(" ");
        String state = stateZipArr[0];
        String zipCode = stateZipArr[1];

        String country = addressArr[3].strip();

        this.setBuildingNumber(houseNum);
        this.setStreet(street);
        this.setCity(city);
        this.setState(state);
        this.setZipCode(zipCode);
        this.setCountry(country);
    }

    @Override
    public String toString() {
        return this.buildingNumber +
                " " + this.street +
                ", " + this.city +
                ", " + this.state +
                ", " + this.zipCode +
                ", " + this.country;
    }
}
