package com.nobo.ir.springpoc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nobo.ir.springpoc.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	List<Product> findAllByProductType(String name);
	
	double findByProductPrice(Integer id);

}
