package com.example.TT.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.querydsl.core.annotations.Config;

@Config
public class WebMvcConfig implements WebMvcConfigurer{

	@Value(value = "${uploadPath}")
	private String uploadPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
 
		registry.addResourceHandler("/imges/**")
				.addResourceLocations(uploadPath);
		
	}

	
}
