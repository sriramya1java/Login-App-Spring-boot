package com.javasampleapproach.jpamysqlangular4.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
	Customer findByUserName(String userName);
	Customer findByPwd(String pwd);
	
}