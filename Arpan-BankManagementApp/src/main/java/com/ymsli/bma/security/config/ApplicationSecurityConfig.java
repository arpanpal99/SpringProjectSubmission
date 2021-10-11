package com.ymsli.bma.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService uDService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(uDService);
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()//.csrf().disable()
		.antMatchers("/account/**").hasAnyRole("MANAGER")
		.antMatchers("/manager/**").hasAnyRole("MANAGER")
		.antMatchers("/transaction/pendingTransaction").hasAnyRole("MANAGER")
		.antMatchers("/transaction/*").hasAnyRole("CLERK", "MANAGER")
		.antMatchers("/customer/**").hasAnyRole("CLERK", "MANAGER")
		.and().formLogin()
		.loginPage("/login").loginProcessingUrl("/myloginprocessor")
			.usernameParameter("empUsername").passwordParameter("empPassword")
			.defaultSuccessUrl("/customer/allCustomers")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied")
		.and().sessionManagement().maximumSessions(1);
	}
	
}
 