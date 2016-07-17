package com.ir.learning.springbootpoc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ir.learning.springbootpoc.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

	List<Customer> findByLastName(String  lastName);
	
	List<Customer> findByName(String name);
	
	Integer retrieveAge(String name);
	
	@Query("SELECT customer FROM Customer customer WHERE customer.age >= :age")
	List<Customer> retrieveCustomer(@Param("age") int age);
	
	@Transactional
	@Modifying
	@Query("UPDATE Customer customer SET customer.age = :age WHERE customer.firstName = :name")
	void updateCustomerAge(@Param("name") String name, @Param("age") int age);
}
