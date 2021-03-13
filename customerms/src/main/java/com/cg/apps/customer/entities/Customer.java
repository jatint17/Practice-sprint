package com.cg.apps.customer.entities;

import com.cg.apps.items.entities.Item;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
public class Customer {

	@GeneratedValue
	@Id
	private Long id;
	private String name;
	@OneToOne
	private Account account;

	@OneToMany(fetch=FetchType.EAGER)
	private Set<Item> boughtItems;


	public Customer(){}

	public Customer(String name, Account account)
	{
	    this.setName(name);
	    this.setAccount(account);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Item> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", account=" + account +
				", boughtItems=" + boughtItems +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(account, customer.account) && Objects.equals(boughtItems, customer.boughtItems);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, account, boughtItems);
	}
}