package com.ogya.reynaldi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ogya.reynaldi.model.Product;



public interface ProductRepository extends CrudRepository<Product, Integer> {
	List<Product> findAll();

	List<Product> findByName(String name);
}
