package com.ir.learning.springbootpoc.rs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ir.learning.springbootpoc.model.NoboIbu;

@Service
public class RestFulWebserviceClient {
	
	private static final Logger logger = LoggerFactory.getLogger(RestFulWebserviceClient.class);
	
	RestTemplate rt = new RestTemplate();
	
	public void getMessage() {
		NoboIbu ni = rt.getForObject("http://localhost:8080/test/getMessage/1", NoboIbu.class);
		
		logger.debug("Message: "+ ni.getMessage());
	
	}
	
	public void putMessage() {
		rt.put("http://localhost:8080/test/putMessage?recipient=ir&message=I%20am%20Ibrahim", NoboIbu.class);
		
		logger.debug("Message added successfully");
	
	}
	
	public void updateMessage() {
		rt.postForObject("http://localhost:8080/test/updateMessage/1?message=I%20am%20Nob", null, NoboIbu.class);
		
		logger.debug("Message updated successfully");
	
	}
	
	public String getRestData(String uriPath) {
		HttpHeaders hh = new HttpHeaders();
		hh.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity = new HttpEntity<String>(hh);
		ResponseEntity<String> re = rt.exchange(uriPath, HttpMethod.GET, httpEntity, String.class);
		logger.debug(re.getBody());
		
		String resonse = rt.getForObject(uriPath, String.class);
		logger.debug("*********");
		logger.debug(resonse);
		return re.getBody();
	}

}
