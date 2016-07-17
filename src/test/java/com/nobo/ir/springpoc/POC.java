package com.nobo.ir.springpoc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ir.learning.springbootpoc.model.Customer;

public class POC {
	
	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		System.out.println(om.writeValueAsString(new Customer("Ibrahim", "Rashid", 31)));
	}

}
