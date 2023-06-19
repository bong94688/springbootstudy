package com.example.TT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//등록 감지
@Configuration
@EnableJpaAuditing
public class AuditConfig {
	
	 
	@Bean
	public AuditorAware<String> auditorProvider(){
		
		return new AuditorAwareImpl();
	}
}
