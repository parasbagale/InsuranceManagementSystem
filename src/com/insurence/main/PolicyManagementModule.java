package com.insurance.main;

import com.insurance.model.Policy;
import java.time.LocalDate;
import java.util.*;

public class PolicyManagementModule {

    //create, update, delete , search policy
     static Map<String, Policy> policyMap = new HashMap<>();


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

    public static void CreatePolicy(){
        Scanner s= new Scanner(System.in);
        System.out.println("Let us create a policy for you. Please provide your details: ");
        System.out.println("Enter customerId: ");
        int customerId = s.nextInt();
        //verify the customerId is valid??  verifyCustomer(Id); Deepak
        System.out.println("Please enter a policy type (Health or Home): ");
        String pType = s.next();

        if("Health".equals(pType) || "Home".equals(pType)){
            //add new policy for a customer
            String newPolicyId = addPolicy(customerId, pType);
            if(newPolicyId != null ){
                System.out.println("Great! The new " + pType + " insurance policy has been created for you. Your policy id is: " + newPolicyId);
            }
        }else{
            System.out.println("Please enter the correct policy type.");
        }
    }

    public static boolean verifyCustomer(int Id){
        //get all ids of customer  Question to Deepak?
        //loop through it to find this id
        //if found return true
        //else false

        return true;
    }

    public static String addPolicy(int customerId, String pType){

        double coverageAmt, premiumAmt;
        String startDate = String.valueOf(LocalDate.now());
        String endDate = String.valueOf(LocalDate.now().plusYears(1));

        switch (pType){
            case "Health":
                coverageAmt = 50000.00;
                premiumAmt = 500.00;
                break;
            case "Home":
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

    public static Map<String, Policy> displayData(){
        return policyMap;
    }









}
