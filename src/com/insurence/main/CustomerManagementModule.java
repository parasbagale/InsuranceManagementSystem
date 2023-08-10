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

        while (customersInfo.containsKey(randomId)) {
            randomId = generateRandomId();
        }

        return randomId;
    }

    private boolean idExists(Integer random) {
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
        Address customerAddress = new Address(); //
        customerAddress.createAddress(strAddress); // ??

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
        System.out.println("Customer " + newCustomer.getFirstName() + " successfully created");
    }

    /**
     * Saves customer
     * */
    public static void saveCustomer(Customer customer){
        customersInfo.put(getUniqueId(), customer);
        System.out.println("Customer created successfully.");
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
            System.out.println("Customer couldn't be found with that id.");
    }


    // print allCustomer
    public  static void printAllCustomers() {
        for (Integer key : customersInfo.keySet()) {
            System.out.println("Customer ID: " + key);
        }
    }



}
