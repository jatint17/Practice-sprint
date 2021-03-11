package com.cg.apps.customermgt.customer.service;

import com.cg.apps.customermgt.customer.bean.Customer;
import com.cg.apps.customermgt.customer.dao.ICustomerDao;
import com.cg.apps.customermgt.customer.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class CustomerServiceImp implements ICustomerService
{
    @Autowired
    private ICustomerDao dao;

    @Override
    public Customer findByID(Long customerID)
    {
        validateId(customerID);
        Customer customer = dao.findByID(customerID);
        return customer;
    }

    @Transactional
    @Override
    public Customer createCustomer(String name)
    {
        Customer customer = new Customer();
        customer.setCustName(name);
        customer = dao.add(customer);
        return customer;
    }

    public void validateId(Long id)
    {
        if(id <0){
            throw new InvalidIdException("id should not be negative");
        }
    }
    void validateName(String name){
        if(name==null || name.isEmpty() || name.trim().isEmpty()){
            throw new InvalidNameException("name can't be null or empty");
        }
    }
}
