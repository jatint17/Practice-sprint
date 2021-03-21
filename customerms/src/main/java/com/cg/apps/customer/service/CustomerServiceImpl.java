package com.cg.apps.customer.service;

import com.cg.apps.customer.dao.IAccountRepository;
import com.cg.apps.customer.dao.ICustomerRepository;
import com.cg.apps.customer.entities.Account;
import com.cg.apps.customer.entities.Customer;
import com.cg.apps.customer.exceptions.*;
import com.cg.apps.items.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;


@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private IAccountRepository accountRepository;
	
	@Transactional
	@Override
	public Customer createCustomer(String name)
	{
		validateName(name);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Customer customer =new Customer();
		Account account = new Account(-1.0,localDateTime);
		
		customer.setAccount(account);
		customer.setName(name);
		accountRepository.save(account);
		customerRepository.save(customer);
		return customer;
	}
	
	@Override
	public Customer findByID(Long customerID) 
	{
		validateId(customerID);
		Optional<Customer>optional = customerRepository.findById(customerID);
		if(!optional.isPresent())
		{
			throw new CustomerNotFoundException("Customer does not exist");
		}
		Customer customer = optional.get();
		return customer;
	}

	@Transactional
	@Override
	public Customer update(Long id, String name) 
	{
		validateName(name);
		Customer customer = findByID(id);
		customer = customerRepository.save(customer);
		return customer;
	}

	@Transactional
	@Override
	public Customer addAmount(long customerId, double amount)
	{
		Customer customer = findByID(customerId);
		Account account = customer.getAccount();
		account.setBalance(amount);
		customer.setAccount(account);
		accountRepository.save(account);
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerID)
	{
		validateId(customerID);
		Customer customer = findByID(customerID);
		Set<Item>itemSet = customer.getBoughtItems();
		return itemSet;
	}

   void validateName(String name)
   {
		if(name==null || name.isEmpty() || name.trim().isEmpty())
		{
			throw new InvalidNameException("name can't be null or empty");
		}
	}

	void validateId(Long id)
	{
		if(id <0)
		{
			throw new InvalidIdException("id should not be negative");
		}
	}

}
