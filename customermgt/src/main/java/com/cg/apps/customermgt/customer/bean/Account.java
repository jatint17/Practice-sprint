package com.cg.apps.customermgt.customer.bean;

import java.time.LocalDateTime;

public class Account 
{
	private Long accountId;
	private Double balance;
	private LocalDateTime created;
	
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
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	
}
