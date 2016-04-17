package com.nobo.ir.springpoc.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
//@EnableWebMvc
@ComponentScan(basePackages="com.nobo.ir.springpoc")
public class SpringBooter extends SpringBootServletInitializer {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBooter.class, args);
		
		
	}
	
	/*@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}*/
	
	/*@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/jsp/");
		irvr.setSuffix(".jsp");
		return irvr;
	}*/
	
	@Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(SpringBooter.class);
    }
}
