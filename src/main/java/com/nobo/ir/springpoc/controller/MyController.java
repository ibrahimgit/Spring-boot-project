package com.nobo.ir.springpoc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nobo.ir.springpoc.model.NoboIbu;
import com.nobo.ir.springpoc.rs.client.RestFulWebserviceClient;

@RestController
public class MyController {
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	@RequestMapping(value={"/nobo"}, method=RequestMethod.GET)
	public ModelAndView myForm(ModelMap map) {
		System.out.println("Hi, I am your dear Nobo and you are my dear Ibu");
		ModelAndView mav = new ModelAndView("index", "name", "Nobo");
		RestFulWebserviceClient client = new RestFulWebserviceClient();
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
		System.out.println("Hi, I am Ibrahim");
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
