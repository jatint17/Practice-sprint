package com.cg.apps.customermgt.customer.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Customer 
{
	@GeneratedValue
	@Id
	private Long custId;
	private String custName;
	//private Account account;
	
	public Customer() {}
	public Customer(String custName)//, Account account)
	{
		this.custName=custName;
		//this.account=account;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

//	public Account getAccount() {
//		return account;
//	}
//
//	public void setAccount(Account account) {
//		this.account = account;
//	}

	@Override
	public String toString() {
		return "Customer{" +
				"custId=" + custId +
				", custName='" + custName; // +	", account=" + account +'}';
	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		Customer customer = (Customer) o;
//		return Objects.equals(custId, customer.custId) && Objects.equals(custName, customer.custName) && Objects.equals(account, customer.account);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(custId, custName, account);
//	}
}