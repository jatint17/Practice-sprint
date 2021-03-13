package com.cg.apps.customer.service;

import com.cg.apps.customer.entities.Account;
import com.cg.apps.customer.entities.Customer;
import com.cg.apps.customer.exceptions.InvalidIdException;
import com.cg.apps.customer.dao.ICustomerDao;
import com.cg.apps.customer.exceptions.InvalidNameException;
import com.cg.apps.items.dao.IItemDao;
import com.cg.apps.items.entities.Item;
import com.cg.apps.items.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;
	@Autowired
	EntityManager entityManager;
	@Autowired
	private IItemService iItemService;
	
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
		entityManager.persist(account);
		dao.add(customer);
		return customer;
	}
	
	@Override
	public Customer findByID(Long customerID) 
	{
		validateId(customerID);
		Customer customer = dao.findByID(customerID);
		return customer;	
	}

	@Transactional
	@Override
	public Customer update(Long id, String name) 
	{
		validateName(name);
		Customer customer = dao.findByID(id);
		customer = dao.update(customer);
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

   void validateName(String name){
		if(name==null || name.isEmpty() || name.trim().isEmpty()){
			throw new InvalidNameException("name can't be null or empty");
		}
	}

	void validateId(Long id){
		if(id <0){
			throw new InvalidIdException("id should not be negative");
		}
	}

}
