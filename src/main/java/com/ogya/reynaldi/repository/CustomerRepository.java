package com.ogya.reynaldi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.ogya.reynaldi.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	List<Customer> findAll();
	List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByAge(int age);
    List<Customer> findByEmail(String email);
    List<Customer> findByMobileNumber(String mobileNumber);
    List<Customer> findByStatus(int status);
    List<Customer> findByGender(int gender);
}