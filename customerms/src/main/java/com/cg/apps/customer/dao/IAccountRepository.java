package com.cg.apps.customer.dao;

import com.cg.apps.customer.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account,Long> {

}
