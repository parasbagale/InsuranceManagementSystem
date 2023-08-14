package com.insurence.main; // ?? adjusted spelling of insurance to remote repo

import com.insurence.model.Address;
import com.insurence.model.Customer;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class CustomerManagementModule extends Customer {

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
        System.out.println("Enter customer first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter customer middle name: ");
        String middleName = scanner.nextLine();
        System.out.println("Enter customer lastname: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter customer date of birth (MM-DD-YYYY): ");
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
                customerDob,
                customerAddress,   // address object
                email,
                customerMobileNumber
        );
        saveCustomer(newCustomer);
    }

    /**
     * Saves customer
     * */
    public static void saveCustomer(Customer customer){
        customer.setCustomerId(getUniqueId());
        customersInfo.put(customer.getCustomerId(), customer);
        System.out.println("Customer created successfully.");
    }

    // Search Customer
    public static void searchCustomer(Integer id) {
        if(idExists(id)) {
            System.out.println("Customer Found");
            System.out.println(customersInfo.get(id));
        }
        else {
            System.out.println("No results found");
        }
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
