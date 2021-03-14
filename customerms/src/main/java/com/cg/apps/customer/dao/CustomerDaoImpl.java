package com.cg.apps.customer.dao;

import com.cg.apps.customer.entities.Customer;
import com.cg.apps.items.exceptions.InvalidPriceException;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Customer add(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer findByID(Long customerID) {
		Customer customer =entityManager.find(Customer.class,customerID);
		if(customer ==null)
		{
			throw new InvalidPriceException("Customer doesn't exist");
		}
		return customer;
	}

	@Override
	public Customer update(Customer customer)
	{
		customer =entityManager.merge(customer);
		return customer;
	}

}
