package com.insurance.main;

import com.insurance.model.Claim;
import com.insurance.model.Customer;
import com.insurance.model.Policy;

import java.sql.Timestamp;
import java.util.*;

import static com.insurance.main.CustomerManagementModule.searchCustomer;
import static com.insurance.main.PolicyManagementModule.policyMap;


public class ClaimManagementModule {
    public static final Map<Integer, Claim> claimMap = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void createClaim(){
        Claim claim = new Claim();
        System.out.println("\t             pls enter your customer Id:  ");
        Integer customerId = scanner.nextInt();
        Customer cust = CustomerManagementModule.searchCustomer(customerId);
        System.out.println("Please enter your policy id");
        String policyId = scanner.nextLine();
        Policy policy = policyMap.get(policyId);

        if(cust != null && policy != null){
            claim.setClaimId((int) Math.random());
            System.out.println("Pls enter claim amount");
            Double claimAmount = scanner.nextDouble();
            claim.setClaimAmount(claimAmount);
            claim.setDateOfClaim(new Timestamp(System.currentTimeMillis()));
            claim.setCustomerId(cust.getCustomerId());
            claim.setClaimFilled(true);
            claim.setPolicyId(policyId);
            claimMap.put(customerId, claim);
        }
    }
    public static void showClaimDetails(){
        System.out.println("Pls enter your customer ID ");
        Integer customerId = scanner.nextInt();
        Claim claim = claimMap.get(customerId);
        System.out.println(claim);
    }
    public static void updateClaimDetails(){
        System.out.println("Update Claim page - only claim amount can be updated.  ");
        System.out.println("Pls enter your customer ID ");
        Integer customerId = scanner.nextInt();
        Customer customer = CustomerManagementModule.searchCustomer(customerId);
        System.out.println("Enter the new claim amount");
        Double claimAmount = scanner.nextDouble();
        Claim newClaim = new Claim();
        Claim existingClaim = claimMap.get(customerId);

        newClaim.setClaimFilled(true);
        newClaim.setClaimId(existingClaim.getClaimId());
        newClaim.setClaimAmount(claimAmount);
        newClaim.setDateOfClaim(existingClaim.getDateOfClaim());
        newClaim.setPolicyId("Policy Id");
        System.out.println("Claim updated successfully");

    }
    public static void deleteClaim(){
        System.out.println("Pls enter your customer ID ");
        Integer customerId = scanner.nextInt();
        Claim deletedClaim = claimMap.remove(customerId);
        System.out.println("Claim Deleted => "+claimMap);

    }
    //returns a claim obj associated with a particular Customer ID
    public static Claim findClaim(Integer customerId){
        return claimMap.get(customerId);
    }
    // returns true if a claim is active for a particular customer
    public static Boolean checkActiveClaim(String customerId){
        return claimMap.get(customerId).getClaimFilled();
    }
}
