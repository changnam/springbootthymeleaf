package com.honsoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	// @Override
	// public void addViewControllers(ViewControllerRegistry registry) {
	// registry.addViewController("/home").setViewName("home");
	// }

	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {
	// registry.addInterceptor(new ThymeleafLayoutInterceptor());
	// }
//	
//	@Bean
//	public LayoutDialect layoutDialect() {
//	    return new LayoutDialect();
//	}
//	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
