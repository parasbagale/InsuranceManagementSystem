package com.insurance.model;

import java.util.Date;

public class Claim {
    private Integer claimId;
    private String policyId;
    private Integer CustomerId;
    private Date dateOfClaim;
    private Double claimAmount;
    Boolean claimFilled = false;

    public Claim() {
    }

    public Claim(Integer claimId, String policyId, Integer customerId, Date dateOfClaim, Double claimAmount, Boolean claimFilled) {
        this.claimId = claimId;
        this.policyId = policyId;
        CustomerId = customerId;
        this.dateOfClaim = dateOfClaim;
        this.claimAmount = claimAmount;
        this.claimFilled = claimFilled;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Integer customerId) {
        CustomerId = customerId;
    }

    public Date getDateOfClaim() {
        return dateOfClaim;
    }

    public void setDateOfClaim(Date dateOfClaim) {
        this.dateOfClaim = dateOfClaim;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Boolean getClaimFilled() {
        return claimFilled;
    }

    public void setClaimFilled(Boolean claimFilled) {
        this.claimFilled = claimFilled;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", policyId='" + policyId + '\'' +
                ", CustomerId=" + CustomerId +
                ", dateOfClaim=" + dateOfClaim +
                ", claimAmount=" + claimAmount +
                ", claimFilled=" + claimFilled +
                '}';
    }
}
