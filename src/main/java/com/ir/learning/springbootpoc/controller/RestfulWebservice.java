package com.ir.learning.springbootpoc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ir.learning.springbootpoc.model.NoboIbu;
import com.ir.learning.springbootpoc.rs.client.RestFulWebserviceClient;


@RestController
@RequestMapping(value = "/test")
public class RestfulWebservice {
	
	Map<Integer, NoboIbu> messages = new HashMap<Integer, NoboIbu>();
	
	// logging framework is SLF4J. The dependent Jars are slf4j-api, slf4j-logrj12, log4j
	private static final Logger logger = LoggerFactory.getLogger(RestfulWebservice.class);
		
	@Autowired
	private RestFulWebserviceClient client;
		
	/*@Autowired
	DataSource datasource;*/
		
	@Value("${springpoc.message}")
	String message;
		
	@Value("${springpoc.test}")
	String testMessage;
		
	@Value("${yml.test.value}")
	String messageYAML;
		
	@Autowired
	Environment environment;
	
	@RequestMapping(value="/loveme", method=RequestMethod.GET)
	public NoboIbu doYouLoveMe() {
		NoboIbu nobo = new NoboIbu("Nobo", "Yes, I love you");
		return nobo;
	}
	
	
	@RequestMapping(value="/getMessage/{id}", method=RequestMethod.GET)
	public NoboIbu getAMessage(@PathVariable(value = "id") Integer key) {
		NoboIbu ni = messages.get(key);
		return ni;
	}
	
	@RequestMapping(value="/getAllMessages", method=RequestMethod.GET)
	public List<NoboIbu> getAllMessages() {
		List<NoboIbu> list = new ArrayList<NoboIbu>(messages.values());
		return list;
	}
	
	@RequestMapping(value="/putMessage", method=RequestMethod.PUT)
	public void putMessage(@RequestParam(value = "recipient") String recipient, @RequestParam(value="message") String message) {
		NoboIbu nobo = new NoboIbu(recipient, message);
		int counter = messages.size() + 1;
		messages.put(counter, nobo);
		//return nobo;
	}
	
	@RequestMapping(value="/updateMessage/{id}", method=RequestMethod.POST)
	public NoboIbu updateMessage(@PathVariable(value = "id") Integer key, @RequestParam(value="message") String message) {
		NoboIbu ni = messages.get(key);
		ni.setMessage(message);
		return ni;
	}
	
	@RequestMapping(value="/deleteMessage/{id}", method=RequestMethod.DELETE)
	public NoboIbu deleteMessage(@PathVariable(value = "id") Integer key) {
		NoboIbu ni= messages.remove(key);
		return ni;
	}
	
	@RequestMapping(value="message", method=RequestMethod.GET)
	public String getAllMessageFromProperties() {
		logger.info("INFO - Message from @Value: " + message);
		logger.debug("Test Message from @Value: " + testMessage);
		logger.warn("WAARN MEssage from Environment: " + environment.getProperty("application.message"));
		logger.debug("YAML MEssage from Environment: " + environment.getProperty("yml.test.message"));
		logger.warn("WARN YAML MEssage from @Value: " + messageYAML);
		logger.debug("Message from default prop: " + environment.getProperty("message.test.profile"));
		
		logger.info("info.build.artifact: " + environment.getProperty("info.build.artifact"));
		logger.debug("info.build.name: " + environment.getProperty("info.build.name"));
		logger.warn("info.build.description: " + environment.getProperty("info.build.description"));
		logger.debug("info.build.version: " + environment.getProperty("info.build.version"));
		return "Message retrieved successfully";
	}
	
	@RequestMapping(value="rest", method=RequestMethod.GET)
	public String testRestWebservice() {
		client.getRestData("http://api.openweathermap.org/data/2.5/weather?q=London&appid=907f14649dd7564b21d2d4a61d954414");
		return "Rest Webservice invoked successfully";
	}
	

}
