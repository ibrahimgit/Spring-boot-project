package com.nobo.ir.springpoc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nobo.ir.springpoc.model.Product;
import com.nobo.ir.springpoc.repository.ProductRepository;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="addProduct", method=RequestMethod.PUT)
	public void addProduct(@RequestBody Product product) {
		productRepository.save(product);
	}
	
	@RequestMapping(value="removeProduct/{id}", method=RequestMethod.DELETE)
	public void removeProduct(@PathVariable("id") Integer id) {
		productRepository.delete(id);
	}
	
	@RequestMapping(value="getProduct", method=RequestMethod.GET)
	public List<Product> getProduct(@RequestParam("productType") String productType) {
		return productRepository.findAllByProductType(productType);
	}
	
	@RequestMapping(value="getPrice/{id}", method=RequestMethod.GET) //not working right now
	public double getPrice(@PathVariable("id") Integer id) {
		return productRepository.findByProductPrice(id);
	}
	
	@RequestMapping(value="getProduct/{id}", method=RequestMethod.GET)
	public Product findById(@PathVariable("id") Integer id) {
		return productRepository.findOne(id);
	}
	
	@RequestMapping(value="getCount", method=RequestMethod.GET)
	public Long getCount() {
		return productRepository.count();
	}
	
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public List<Product> getAllProduct() {
		List<Product> productList = new ArrayList<Product>();
		productRepository.findAll().forEach(item -> productList.add(item));
		return productList;
	}
	
	/*@ExceptionHandler(Exception.class)
	public ApplicationException handleException(Exception ex){
		return new ApplicationException(ex.getMessage(), ex.getLocalizedMessage());
	}*/

}
