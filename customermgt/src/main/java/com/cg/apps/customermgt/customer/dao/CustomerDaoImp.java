package com.cg.apps.customermgt.customer.dao;

import com.cg.apps.customermgt.customer.bean.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDaoImp implements ICustomerDao
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer add(Customer customer)
    {
        entityManager.persist(customer);
        return customer;
    }

    @Override
    public Customer findByID(Long customerID)
    {
        Customer customer = entityManager.find(Customer.class,customerID);
        return customer;
    }

    @Override
    public Customer update(Customer customer)
    {
        customer = entityManager.merge(customer);
        return customer;
    }
}
