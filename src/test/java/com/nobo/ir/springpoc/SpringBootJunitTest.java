package com.nobo.ir.springpoc;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ir.learning.springbootpoc.SpringBooter;
import com.ir.learning.springbootpoc.controller.ProductController;
import com.ir.learning.springbootpoc.model.Product;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBooter.class)
public class SpringBootJunitTest {
	
	@Autowired
	ProductController productController;
	
	@Test
	public void getAllProduct() {
		Product product = new Product();
		product.setProductType("A");
		product.setProductPrice(20.0);
		productController.addProduct(product);
		product = new Product();
		product.setProductType("B");
		product.setProductPrice(30.0);
		productController.addProduct(product);
		product = new Product();
		product.setProductType("C");
		product.setProductPrice(40.0);
		productController.addProduct(product);
		
		//List<Product> allProduct = productController.getAllProduct();
		/*System.out.println("List size: " + allProduct.size());
		assertEquals(allProduct.size(),3);
		assertEquals(allProduct.get(0).getProductType(),"A");
		
		allProduct = productController.getProduct("B");
		assertEquals(allProduct.size(),1);*/
		
		double price = productController.getPrice(3);
		assertEquals(price, 40.0, 0.0);
		
		Product prd = productController.findById(1);
		assertEquals(prd.getProductType(), "A");
		
		long count = productController.getCount();
		assertEquals(count, 3L);
		
		productController.updateProductPrice(3, 50.0);
		
		price = productController.getPrice(3);
		assertEquals(price, 50.0, 0.0);
		
	}

}
