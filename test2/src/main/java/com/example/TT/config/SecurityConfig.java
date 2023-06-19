package com.example.TT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 
//		로그인 서비스 구현 로그인 성공햇을때 로그인 실패했을때 이동페이지
		http.formLogin()
			.loginPage("/member/login")
			.defaultSuccessUrl("/")
			.usernameParameter("email")
			.failureUrl("/member/login/error")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
			.logoutSuccessUrl("/");
			
//		권한확인 permitAll-> 모두 허용 hasRole("ADMIN") -> ADMIN만 .mvcMatchers("/css/**").permitAll() -> css 허용
//  	15강
		http.authorizeRequests()
			.mvcMatchers("/css/**","/js/**").permitAll()
			.mvcMatchers("/","/member/**","/item/**").permitAll() 
			.mvcMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated();
		
		http.exceptionHandling()
			.authenticationEntryPoint(new CustomEntryPoint());
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {

	
		return new BCryptPasswordEncoder();
	}
}
