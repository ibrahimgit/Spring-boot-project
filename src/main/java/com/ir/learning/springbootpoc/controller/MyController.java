package com.ir.learning.springbootpoc.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ir.learning.springbootpoc.model.NoboIbu;
import com.ir.learning.springbootpoc.rs.client.RestFulWebserviceClient;

@RestController
@ConfigurationProperties("ibrahim.test")
public class MyController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class); 
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	private String name;
	private int age;
	private List<String>  values;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}
	
	//@RequestMapping(value="")
	//public String testRedirect(HttpRequestWrapper)
	

	@RequestMapping(value = "getDataFromProp", method=RequestMethod.GET)
	public NoboIbu getDataFromProp() {
		return new NoboIbu(name, age, values);
	}
	
	@RequestMapping(value={"/nobo"}, method=RequestMethod.GET)
	public ModelAndView myForm(ModelMap map) {
		logger.debug("Hi, I am your dear Nobo and you are my dear Ibu");
		ModelAndView mav = new ModelAndView("index", "name", "Nobo");
		RestFulWebserviceClient client = new RestFulWebserviceClient();
		client.putMessage();
		client.getMessage();
		client.putMessage();
		client.updateMessage();
		return mav;
		/*map.addAttribute("name", "Nobo");
		map.addAttribute("age", "30");
		return "greeting";*/
	}
	
	@RequestMapping(value = "getMessage", method=RequestMethod.GET, produces="application/json")
	public NoboIbu getMessage(){
		NoboIbu noboIbu = new NoboIbu("Secret", message);
		return noboIbu;
	}
	
	
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public ModelAndView myDetails(@RequestParam(value="name") String name, @RequestParam(value="age") String age){
		logger.debug("Hi, I am Ibrahim");
//		Employee emp = new Employee(name, age);
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("age", age);	
		mav.setViewName("myDetails");
		return mav;
	}
	
	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}

}
