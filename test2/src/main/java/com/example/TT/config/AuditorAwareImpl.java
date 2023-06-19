package com.example.TT.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String>{
 
	@Override
	public Optional<String> getCurrentAuditor() {
	    Authentication authentication = 
	            SecurityContextHolder.getContext().getAuthentication();
	    String userId = "anonymous"; // 인증되지 않은 사용자를 위한 기본값 설정
	    
	    if(authentication != null && authentication.isAuthenticated() && !authentication.getName().equals("anonymousUser")) {
	        userId = authentication.getName();
	    }
	    
	    return Optional.of(userId);
	}

	
}
