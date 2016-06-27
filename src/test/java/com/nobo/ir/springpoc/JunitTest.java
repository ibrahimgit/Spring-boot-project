package com.nobo.ir.springpoc;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnit44Runner;

import com.nobo.ir.springpoc.controller.ProductController;
import com.nobo.ir.springpoc.model.Product;
import com.nobo.ir.springpoc.repository.ProductRepository;



@RunWith(MockitoJUnit44Runner.class)
public class JunitTest {
	
	@Mock
	private ProductRepository productRepository;
	ProductController pc;
	
	@Before
	public void setUp() {
		pc = new ProductController();
		pc.setProductRepository(productRepository);
	}
	
	@Test
	public void MockTest() {
		Assert.assertNotNull(productRepository);
		System.out.println("productRepository is not null");
		
	}
	
	@Test
	public void addProductTest() {
		Product product = new Product();
		Mockito.when(productRepository.save(product)).thenReturn(product);
		//Mockito.doNothing().when(productRepository).save(product);
		pc.addProduct(product);
		Mockito.verify(productRepository, Mockito.atLeastOnce()).save(product);
	}
	
	@Test
	public void getProductTest() {
		String productType = "";
		List<Product> products = pc.getProduct(productType);
		Mockito.when(productRepository.findAllByProductType(Mockito.any(String.class))).thenReturn(new ArrayList<>());
		
		Assert.assertTrue(products.size() == 0);
		Mockito.verify(productRepository).findAllByProductType(Mockito.any(String.class));
	}
	
	@Test
	public void getAllProductTest() {
		Mockito.when(productRepository.findAll()).thenReturn(new ArrayList<Product>());
		List<Product> allProduct = pc.getAllProduct();
		Mockito.verify(productRepository).findAll();
		Mockito.verify(productRepository, Mockito.atLeastOnce()).findAll();
		Assert.assertEquals(allProduct.size(), 0);
		
	}

}
