package com.college.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.college"})
public class CollegeMvcConfig  implements WebMvcConfigurer{
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
		
	}
//	@Override
//	public void configureHandlerExceptionResolvers(
//		                  	List<HandlerExceptionResolver>resolver) {
//		SimpleMappingExceptionResolver simpleResolver =new
//				                               SimpleMappingExceptionResolver();
//		simpleResolver.setDefaultErrorView("error");//global
//		Properties properties = new Properties();
//		properties.put("java.lang.Exception","errorBook");
//		simpleResolver.setExceptionMappings(properties);
//		resolver.add(simpleResolver);
//		WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolver);
//		
//	}
	
//	@Bean
//	public CommonsMultipartResolver multiresolver() {
//		return new CommonsMultipartResolver();
//		
//	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
