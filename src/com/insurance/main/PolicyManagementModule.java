package com.insurance.main;

import com.insurance.model.Customer;
import com.insurence.model.Policy;


import java.time.LocalDate;
import java.util.*;

public class PolicyManagementModule {

    //create, update, delete , search policy
    static Map<String, Policy> policyMap = new HashMap<>();
    static Scanner s= new Scanner(System.in);
    static HashMap<Integer, Customer> customerMap = new HashMap<>();


     //Policy p1 = new Policy(101,"1011","Health Insurance",50000.0,50.0,"2022-10-10","2023-10-10","Active",true);
    //policyMap.put(101, p1); Deepak??


    public static void displayPolicyMenu(){
        System.out.println("____________________________________________");
        System.out.println("Policy Menu: ");
        System.out.println("1. Create a Policy. Please enter 1 to create a new policy.");
        System.out.println("2. Update a Policy. Please enter 2 to update an existing policy.");
        System.out.println("3. Delete a Policy. Please enter 3 to delete an existing policy");
        System.out.println("4. Search a Policy. Please enter 4 to search an existing policy");
    }
    public static void createPolicy(){
        System.out.println("Let us create a policy for you. Please provide your details: ");
        System.out.println("Enter customerId: ");
        int customerId = s.nextInt();
        //verify the customerId
        if(verifyCustomer(customerId) == true) {
            System.out.println("Please enter a policy type (Health or Home): ");
            String pType = s.next();

            if ("Health".equalsIgnoreCase(pType) || "Home".equalsIgnoreCase(pType)) {
                //add new policy for a customer
                String newPolicyId = addPolicy(customerId, pType);
                if (newPolicyId != null) {
                    System.out.println("Great! The new " + pType + " insurance policy has been created for you. Your policy id is: " + newPolicyId);
                }
            } else {
                System.out.println("Please enter the correct policy type.");
            }
        }else{
            System.out.println("Sorry! Customer does not exist.");
        }
    }
    public static boolean verifyCustomer(int id){
        boolean found = false;
        if (customerMap.containsKey(id)){
          found = true;
        }
        return found;
    }


    public static String addPolicy(int customerId, String pType){

        double coverageAmt, premiumAmt;
        String startDate = String.valueOf(LocalDate.now());
        String endDate = String.valueOf(LocalDate.now().plusYears(1));

        switch (pType.toUpperCase()){
            case "HEALTH":
                coverageAmt = 50000.00;
                premiumAmt = 500.00;
                break;
            case "HOME":
                coverageAmt = 200000.00;
                premiumAmt = 1000.00;
                break;
            default:
                coverageAmt = 0.0;
                premiumAmt = 0.0;
        }

        //create a policy object
        Policy newPolicy = new Policy("1001", pType, coverageAmt,premiumAmt,startDate, endDate, "Active", true);

        //store it in hashmap
        policyMap.put(newPolicy.getPolicyId(), newPolicy);
        return newPolicy.getPolicyId();
    }

    public static void updatePolicy(String policyId){
        System.out.println("Please enter policyId you want to update: ");
        String input = s.next();
        //check input
        showPolicyInfo(input);
        System.out.println("You can only update policy status! Enter Yes/No");
        String word = s.next();
        if(word.equalsIgnoreCase("Yes")){
            updatePolicyStatus(policyId);
        }
    }

    public static void showPolicyInfo(String id){
        Policy currentPolicy = policyMap.get(id);
        System.out.println("Your policy details: \n");
        System.out.println("CustomerId: " + currentPolicy.getCustomerId());
        System.out.println("Policy Type: " + currentPolicy.getPolicyType());
        System.out.println("Coverage: " + currentPolicy.getCoverageAmount());
        System.out.println("Monthly Premium: " + currentPolicy.getPremiumAmount());
        System.out.println("Start date: " + currentPolicy.getStartDate());
        System.out.println("End date: " + currentPolicy.getEndDate());
        System.out.println("Policy status: " + currentPolicy.getStatus());
        System.out.println("Claim status: " + currentPolicy.isClaimed());
    }
    public static void updatePolicyStatus(String policyId){
        Policy currentPolicy = policyMap.get(policyId);
        String currentStatus = currentPolicy.getStatus();
        if("Active".equalsIgnoreCase(currentStatus)){
            currentPolicy.setStatus("Inactive");
            System.out.println("Policy status updated to inactive.");
        }else{
            currentPolicy.setStatus("Active");
            System.out.println("Policy status updated to active.");
        }
    }
    public static void deletePolicy(String policyId){
        Policy currentPolicy = policyMap.get(policyId);
        policyMap.remove(policyId);
        System.out.println(policyId + " has been successfully removed from the system.");
    }
    public static void searchPolicy(String policyId){
        boolean found = false;
        for(Map.Entry<String, Policy> entry : policyMap.entrySet()){
            if( entry.getKey().equals(policyId)){
                found = true;
                showPolicyInfo(policyId);
                break;
            }
        }

        if(!found){
            System.out.println("Sorry, policy not found!");
        }
    }
    public static Map<String, Policy> displayData(){
        return policyMap;
    }

}
