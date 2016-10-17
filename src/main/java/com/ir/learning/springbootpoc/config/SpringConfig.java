package com.ir.learning.springbootpoc.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ir.learning.springbootpoc.model.Employee;
import com.ir.learning.springbootpoc.model.NoboIbu;
import com.ir.learning.springbootpoc.model.Product;

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
	
	@Bean
	public FilterRegistrationBean corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("OPTIONS");
	    config.addAllowedMethod("HEAD");
	    config.addAllowedMethod("GET");
	    config.addAllowedMethod("PUT");
	    config.addAllowedMethod("POST");
	    config.addAllowedMethod("DELETE");
	    config.addAllowedMethod("PATCH");
	    source.registerCorsConfiguration("/**", config);
	    final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	    bean.setOrder(0);
	    return bean;
	}
	/*@Bean
	public DataSource getDataSource() {
		DataSource ds = new JdbcDataSource();
		return ds;
	}*/

}
