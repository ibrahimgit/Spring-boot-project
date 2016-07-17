package com.ir.learning.springbootpoc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ir.learning.springbootpoc.model.NoboIbu;


@RestController
@RequestMapping(value = "/test")
public class RestfulWebservice {
	
	Map<Integer, NoboIbu> messages = new HashMap<Integer, NoboIbu>();
	
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
	

}
