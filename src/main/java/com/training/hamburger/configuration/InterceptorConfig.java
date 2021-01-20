/**
 * 
 */
package com.training.hamburger.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.training.hamburger.interceptor.ExecutionTimeInterceptor;
import com.training.hamburger.interceptor.RequestValidatorInterceptor;

/**
 * @author balaji
 *
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer  {
	
	@Autowired
	ExecutionTimeInterceptor timeInterceptor;
	
	@Autowired
	RequestValidatorInterceptor requstValidatorInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor);
		
		/*
		 * registry.addInterceptor(requstValidatorInterceptor)
		 * .addPathPatterns("/api/locations/*"); //.excludePathPatterns("/menus/*");
		 */	}
}
