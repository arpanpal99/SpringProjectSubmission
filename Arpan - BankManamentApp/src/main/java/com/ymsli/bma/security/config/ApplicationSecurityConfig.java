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
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		/*.antMatchers("/manager/**").hasAnyAuthority("MANAGER")
		.antMatchers("/transaction/**").hasAnyAuthority("CLERK", "MANAGER")
		.antMatchers("/customer/**").hasAnyAuthority("CLERK", "MANAGER")*/
		//.antMatchers("/home/**").hasAnyAuthority("CLERK", "MANAGER")
		.and().formLogin()
		.loginPage("/login").loginProcessingUrl("/myloginprocessor")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/")
		.permitAll()
		.and()
		.logout()
		.permitAll()
		.and()
		.httpBasic()
		.and()
		.exceptionHandling().accessDeniedPage("/accessdenied")
		.and().sessionManagement().maximumSessions(1);
	}
	
}
