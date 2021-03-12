package com.cg.apps.customer.service;

import com.cg.apps.customer.entities.Customer;
import com.cg.apps.customer.exceptions.InvalidIdException;
import com.cg.apps.customer.dao.ICustomerDao;
import com.cg.apps.customer.exceptions.InvalidNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao dao;

	@Override
	public Customer findByID(Long customerID) {
		validateId(customerID);
		Customer customer = dao.findByID(customerID);
		return customer;	}

	@Transactional
	public Customer createCustomer(String name)
	{
		validateName(name);
		Customer customer =new Customer();
		customer.setName(name);
		dao.add(customer);
		return customer;
	}

	@Transactional
	@Override
	public Customer update(Long id, String name) {
		validateName(name);
		Customer customer = dao.findByID(id);
		customer = dao.update(customer);
		return customer;

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
