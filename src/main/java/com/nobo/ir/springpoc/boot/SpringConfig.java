package com.nobo.ir.springpoc.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nobo.ir.springpoc.model.Employee;
import com.nobo.ir.springpoc.model.NoboIbu;
import com.nobo.ir.springpoc.model.Product;

@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("Home");
	}
	
	@Bean
	@Profile("dev") // to activate, a profile run spring-boot:run -Dspring.profiles.active=dev
	public Employee getEmployee() {
		System.out.println("DEV profile");
		return new Employee("","");
	}
	
	@Bean
	@Profile("prod")
	public NoboIbu getNoboIbu() {
		System.out.println("PROD profile");
		return new NoboIbu("","");
	}
	
	@Bean
	@Profile("default")
	public Product getProduct() {
		System.out.println("default profile");
		return new Product();
	}
	
	/*@Bean
	public DataSource getDataSource() {
		DataSource ds = new JdbcDataSource();
		return ds;
	}*/

}
