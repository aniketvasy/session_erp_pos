package com.aniketsenvasy.sessionerppos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.aniketsenvasy.sessionerppos.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  // so we can specify role based access in directly controller.
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// below is method chaining
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/public/**").hasRole("NORMAL")
		.antMatchers("/users/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
	    .and()
	    .httpBasic()  
	    .and()
	    .formLogin()  // to specify that we want to use form login
	    .loginPage("/login")
        .permitAll()
        .defaultSuccessUrl("/ems/", true);
		
		
		////////////////////////    
		
		
//		 http
//	        .csrf().disable()
//	        .authorizeRequests()
//	            .anyRequest().permitAll()
//	        .and()
//	        .httpBasic().disable()
//	        .formLogin().disable();
//     
//	    ;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Configure users for login
		// auth.inMemoryAuthentication().withUser("aniket").password("123").roles("NORMAL");
		// // without encoding
		// auth.inMemoryAuthentication().withUser("sid").password("456").roles("ADMIN");
		// // without encoding
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

//		auth.inMemoryAuthentication().withUser("aniket").password(this.passwordEncoder().encode("123")).roles("NORMAL"); // with
//																															// encoding
//		auth.inMemoryAuthentication().withUser("sid").password(this.passwordEncoder().encode("456")).roles("ADMIN"); // with
//																														// encoding

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// return NoOpPasswordEncoder.getInstance(); // to not use any password encoder.

		return new BCryptPasswordEncoder(10); // to use Bcrypt encoding.
	}

}

