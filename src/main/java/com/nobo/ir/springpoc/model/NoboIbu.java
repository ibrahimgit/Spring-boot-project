package com.nobo.ir.springpoc.model;

import java.util.List;

public class NoboIbu {
	
	private String name;
	private String message;
	private int age;
	private List<String> values;
	
	public NoboIbu() {
		
	}
	
	public NoboIbu(String name, int age, List<String> values) {
		this.name = name;
		this.age = age;
		this.values = values;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getValues() {
		return values;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	public NoboIbu(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
