package com.ir.learning.springbootpoc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ir.learning.springbootpoc.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	List<Product> findAllByProductType(String name);
	
	double getProductPrice(@Param("id") Integer id);
	
	@Modifying
	@Transactional
	@Query("UPDATE Product product SET product.productPrice = :newPrice WHERE product.id = :id")
	void updatePrice(@Param("id") Integer id, @Param("newPrice") double newPrice);

}
