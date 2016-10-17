package com.ir.learning.springbootpoc.rs.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hazelcast.com.eclipsesource.json.JsonObject;
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
	
	public void getWeatherOpenWeatherMap() {
		String response = rt.getForObject("http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=907f14649dd7564b21d2d4a61d954414", String.class);
		logger.debug(response);
		logger.debug("*********************");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		/*httpHeaders.set("Access-Control-Allow-Origin", "*");
		httpHeaders.set("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");*/
		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		
		ResponseEntity<String> re = rt.exchange("http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=907f14649dd7564b21d2d4a61d954414", HttpMethod.GET, httpEntity, String.class);
		logger.debug(re.getBody());
		//JsonObject jsonObject = new JS
	}

}
