package com.cg.apps.customer.dto;

public class CustomerDetails
{
    private Long customerId;
    private String name;
    private Long accountId;
    private Double balance;

    public CustomerDetails(Long customerId,String name, Long accountId, Double balance)
    {
        this.customerId=customerId;
        this.name=name;
        this.accountId=accountId;
        this.balance=balance;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
