package com.cg.apps.customer.service;

import com.cg.apps.customer.entities.Customer;
import com.cg.apps.customer.exceptions.CustomerNotFoundException;
import com.cg.apps.customer.exceptions.InvalidIdException;
import com.cg.apps.customer.util.CustomerUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

@ExtendWith(SpringExtension.class)
@Import(CustomerServiceImpl.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class CustomerServiceTest
{

    @Autowired
    ICustomerService service;

    @Autowired
    private EntityManager entityManager;

    //scenario: student exists in the store
    //precondition: student is in the store, so we'll add it in the store here before testing
    @Test
    public void testFindById_1()
    {
        Customer customer = new Customer("Mahi",null);
        entityManager.persist(customer);
        Long assignedId = customer.getId();;
        //testing
        Customer result = service.findByID(assignedId);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(assignedId,result.getId());
        Assertions.assertEquals("Mahi",result.getName());
    }

    //scenario: student does not exist
    @Test
    public void testFindById_2()
    {
        Executable executable=()->service.findByID(133L);
        Assertions.assertThrows(CustomerNotFoundException.class,executable);
    }

    //when id is negative
    @Test
    public void testFindById_3()
    {
        Executable executable=()->service.findByID(-19L);
        Assertions.assertThrows(InvalidIdException.class,executable);
    }
//
//    @Test
//    public void testAdd_1()
//    {
//        Student result = service.addStudent("Kush",69);
//        Assertions.assertNotNull(result);
//        Assertions.assertEquals(1,store.size());
//        int resId = result.getId();
//        Student stored = store.get(resId);
//        Assertions.assertEquals(result.getName(),stored.getName());
//        Assertions.assertEquals(result.getScore(),stored.getScore());
//    }
}
