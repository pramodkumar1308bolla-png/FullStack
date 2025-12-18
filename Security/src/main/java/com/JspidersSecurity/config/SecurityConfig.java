package com.JspidersSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.mysql.cj.protocol.AuthenticationProvider;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

	@Bean
	UserDetailsService detailsService(BCryptPasswordEncoder passencoder) {
//
////		UserDetails u1 = User.withUsername("pramod").password(passencoder.encode("123")).roles("USER").build();// http://localhost:8080/demo/info1
////
//		UserDetails u2 = User.withUsername("virat").password(passencoder.encode("123")).roles("ADMIN").build();// http://localhost:8080/demo/info2
//
////		return new InMemoryUserDetailsManager(u1, u2);
		return new UserInfoUSerDetailsService();
//
	}

	@Bean
	BCryptPasswordEncoder bCryptoPasswordEncder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		return httpSecurity.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests((auth) -> auth.requestMatchers("/demo/info1").permitAll())
				.authorizeHttpRequests((auth) -> auth.requestMatchers("/demo/**").authenticated())
				.formLogin((form) -> form.permitAll()).build();

	}

//	@Bean
//	AuthenticationProvider authenticationProvider(UserDetailsService userDetailsServices,
//			BCryptPasswordEncoder bcryptPasswordEncoder) {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsServices);
//		provider.setPasswordEncoder(bcryptPasswordEncoder);
//		return provider;
		
//	}

}
