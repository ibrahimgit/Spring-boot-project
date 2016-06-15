package com.nobo.ir.springpoc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;



@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses={ProductRepository.class, Product.class}) // not required if @SpringBootApplication is there with default settings
//@EnableTransactionManagement// not required if @SpringBootApplication is there
//@EnableWebMvc // not required if @SpringBootApplication is there
//@ComponentScan/*(basePackages="com.nobo.ir.springpoc")*/
public class SpringBooter /*extends SpringBootServletInitializer*/ /*extends WebMvcConfigurerAdapter*/ {

	
	public static void main(String[] args) {
		//SpringApplication.run(SpringBooter.class, args);
		new SpringApplicationBuilder(SpringBooter.class).run(args);
		
	}
	
	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("Home");
	}*/
	
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
	
	/*Note that a WebApplicationInitializer is only needed if you are building a war file and deploying it.
	If you prefer to run an embedded container then you won't need this at all.
*/	
	/*@Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(SpringBooter.class);
    }*/
}
