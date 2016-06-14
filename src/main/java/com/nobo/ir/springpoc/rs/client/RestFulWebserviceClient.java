package com.nobo.ir.springpoc.rs.client;

import org.springframework.web.client.RestTemplate;

import com.nobo.ir.springpoc.model.NoboIbu;

public class RestFulWebserviceClient {
	
	RestTemplate rt = new RestTemplate();
	
	public void getMessage() {
		NoboIbu ni = rt.getForObject("http://localhost:8080/test/getMessage/1", NoboIbu.class);
		
		System.out.println("Message: "+ ni.getMessage());
	
	}
	
	public void putMessage() {
		rt.put("http://localhost:8080/test/putMessage?recipient=ir&message=I%20am%20Ibrahim", NoboIbu.class);
		
		System.out.println("Message added successfully");
	
	}
	
	public void updateMessage() {
		rt.postForObject("http://localhost:8080/test/updateMessage/1?message=I%20am%20Nob", null, NoboIbu.class);
		
		System.out.println("Message updated successfully");
	
	}

}
