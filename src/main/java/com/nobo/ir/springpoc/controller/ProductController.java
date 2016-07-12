package com.nobo.ir.springpoc.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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
	
	// logging framework is SLF4J. The dependent Jars are slf4j-api, slf4j-logrj12, log4j
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Value("${springpoc.message}")
	String message;
	
	@Value("${springpoc.test}")
	String testMessage;
	
	@Value("${yml.test.value}")
	String messageYAML;
	
	@Autowired
	Environment environment;
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value="addProduct", method=RequestMethod.PUT)
	public void addProduct(@RequestBody Product product) {
		logger.debug("Date: " + product.getProdctMfgDate());
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
		return productRepository.getProductPrice(id);
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
		logger.debug("Message from @Value: " + message);
		logger.debug("Test Message from @Value: " + testMessage);
		logger.debug(" MEssage from Environment: " + environment.getProperty("application.message"));
		logger.debug("YAML MEssage from Environment: " + environment.getProperty("yml.test.message"));
		logger.debug("YAML MEssage from @Value: " + messageYAML);
		List<Product> productList = new ArrayList<Product>();
		productRepository.findAll().forEach(item -> productList.add(item));
		return productList;
	}
	
	@RequestMapping(value="updateProductPrice/{id}", method=RequestMethod.PUT)
	public void updateProductPrice(@PathVariable("id") Integer id, @RequestParam("newPrice") double newPrice) {
		productRepository.updatePrice(id, newPrice);
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
		
	}
	
	/*@ExceptionHandler(Exception.class)
	public ApplicationException handleException(Exception ex){
		return new ApplicationException(ex.getMessage(), ex.getLocalizedMessage());
	}*/

}
