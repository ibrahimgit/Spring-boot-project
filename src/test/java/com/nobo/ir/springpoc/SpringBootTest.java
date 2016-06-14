package com.nobo.ir.springpoc;


import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nobo.ir.springpoc.model.Product;

public class SpringBootTest {
	
	public static void main(String[] args) throws JsonProcessingException {
		Product product = new Product("P1", "A", "Test", 0.0, new Date());
		
		ObjectMapper om = new ObjectMapper();
		System.out.println(om.writeValueAsString(product));
	}

}
