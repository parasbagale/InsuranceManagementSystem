package com.insurance.main;

import com.insurance.model.Address;
import com.insurance.model.Customer;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class CustomerManagementModule {

    // create map
    static HashMap<Integer, Customer> customersInfo = new HashMap<>();

    private static Integer getUniqueId() {
        Integer randomId = generateRandomId();

        while (idExists(randomId)) {
            randomId = generateRandomId();
        }

        return randomId;
    }

    private static boolean idExists(Integer random) {
        return customersInfo.containsKey(random);
    }


    private static Integer generateRandomId() {
        Random random = new Random();

        // Generate a random number between 1000 and 10000 (inclusive)
        return random.nextInt(9001) + 1000;
    }

    public static void createCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer's first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter customer's middle name: ");
        String middleName = scanner.nextLine();
        System.out.println("Enter customer's lastname: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter customer's password: ");
        String password = scanner.nextLine();
        System.out.println("Enter customer's date of birth (MM-DD-YYYY): ");
        String customerDob = scanner.nextLine();

        System.out.println("Enter Address (0000 st-address, city, STATE-CODE zip-code, country): ");
        String strAddress = scanner.nextLine();
        Address customerAddress = new Address(strAddress); //

        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter phone num (123-456-7890): ");
        String customerMobileNumber = scanner.nextLine();

        Customer newCustomer = new Customer(
                firstName,
                middleName,
                lastName,
                password,
                customerDob,
                customerAddress,   // address object
                email,
                customerMobileNumber
        );
        saveCustomer(newCustomer);
    }

    public static void createAuto() {
        String firstName = "Testa";
        String middleName = "T.";
        String lastName = "Test";
        String password = "test123";
        String customerDob = "1998-08-28";
        Address address = new Address("12 King St., Toronto, ON L8V1G3, Canada");
        String email = "test@test.com";
        String customerMobileNumber = "9849598495";
        for(int i=0; i<10; i++) {
            Customer cust = new Customer(
                    firstName,
                    middleName,
                    lastName,
                    password,
                    customerDob,
                    address,
                    email,
                    customerMobileNumber);
            CustomerManagementModule.saveCustomer(cust);
        }
    }

    /**
     * Saves customer
     * */
    public static void saveCustomer(Customer customer){
        customer.setCustomerId(getUniqueId());

        if(!idExists(customer.getCustomerId())) {
            customersInfo.put(customer.getCustomerId(), customer);
            System.out.println("Customer created successfully.");
        }
        else {
            System.out.println("Something went wrong");
        }
    }
    public static void saveCustomer(Customer customer, Integer id){
        customer.setCustomerId(id);

        if(idExists(customer.getCustomerId())) {
            customersInfo.put(customer.getCustomerId(), customer);
            System.out.println("Customer created successfully.");
        }
        else {
            System.out.println("Something went wrong");
        }
    }

    // Update customer
    public static void updateCustomer(Integer id) {
        if(idExists(id)) {
            Customer cust = customersInfo.get(id);
            System.out.println("Enter what field you want to update from the options below:");
            System.out.println("firstname, middlename, lastname, password, dob, address, email, mobilenumber?");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase().trim();
            boolean hasUpdated = true;
            switch (input) {
                case "firstname":
                    System.out.println("Enter new firstName: ");
                    cust.setFirstName(scanner.nextLine());
                    break;
                case "middlename":
                    System.out.println("Enter new middleName: ");
                    cust.setMiddleName(scanner.nextLine());
                    break;
                case "lastname":
                    System.out.println("Enter new lastName: ");
                    cust.setLastName(scanner.nextLine());
                    break;
                case "password":
                    System.out.println("Enter new password: ");
                    cust.setPassword(scanner.nextLine());
                    break;
                case "dob":
                    System.out.println("Enter new DOB: ");
                    cust.setCustomerDob(scanner.nextLine());
                    break;
                case "address":
                    System.out.println("Enter new address: ");
                    cust.setAddress(new Address(scanner.nextLine()));
                    break;
                case "email":
                    System.out.println("Enter new email: ");
                    cust.setEmail(scanner.nextLine());
                    break;
                case "mobilenumber":
                    System.out.println("Enter new mobileNumber: ");
                    cust.setCustomerMobileNumber(scanner.nextLine());
                    break;
                default:
                    hasUpdated = false;
                    System.out.println("Invalid input");
            }
            if (hasUpdated) {
                System.out.println("Update successful!");
                System.out.println("Update Information:");
                System.out.println(cust);
            }
        }
        else {
            System.out.println("No customer found!");
        }
    }

    // Search Customer
    public static Customer searchCustomer(Integer id) {
        if(idExists(id)) {
            System.out.println("Customer Found");
            return (customersInfo.get(id));
        }
        return null;
    }

    public static Customer searchCustomer(String firstName) {
        for(Integer key : customersInfo.keySet()) {
            if (customersInfo.get(key).getFirstName().equals(firstName)) {
                System.out.println("Customer Found");
                return (customersInfo.get(key));
            }
        }
        return null;
    }

    /**
     * Deletes customer
     * */
    public static void deleteCustomer(Integer id) {
        if (customersInfo.containsKey(id)){
            customersInfo.remove(id);
            System.out.println("Customer successfully deleted.");
        }
        else
            System.out.println("Customer " + id + " couldn't be found.");
    }

    // printall Customers
    public  static void printAllCustomers() {
        for (Integer key : customersInfo.keySet()) {
            System.out.println(customersInfo.get(key));
        }
    }
}
