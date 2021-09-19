package com.honsoft.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.honsoft.servlet.MyServlet;

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
	
    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }
    
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }
    
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
	public ServletRegistrationBean<MyServlet> servletRegistrationBean(){
		ServletRegistrationBean<MyServlet> servletBean = new ServletRegistrationBean<MyServlet>();
		servletBean.setServlet(new MyServlet());
		servletBean.addUrlMappings("/myservlet");
		
		return servletBean;
	}
}
