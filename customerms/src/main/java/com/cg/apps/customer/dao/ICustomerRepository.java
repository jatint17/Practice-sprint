package com.cg.apps.customer.dao;

import com.cg.apps.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long>
{

//    List<Customer> findCustomerByName(String name);

}
