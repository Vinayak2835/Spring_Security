package com.saleniumexpress.config;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpRequest;
import org.springframework.http.HttpRequest;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfigure extends WebSecurityConfigurerAdapter {
	//this class is helps you to create the spring security filter chain
	
	
	
	@Autowired
	private DataSource dataSoure;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSoure).passwordEncoder(passwordEncoder);
		
	}
	*/
	
	protected void configure(AuthenticationManagerBuilder auth) {
		
		ArrayList<GrantedAuthority>  roles = new ArrayList<GrantedAuthority>();
		
		SimpleGrantedAuthority role1 = new SimpleGrantedAuthority("Admin");
		SimpleGrantedAuthority role2 = new SimpleGrantedAuthority("Coder");
		
		roles.add(role1);
		roles.add(role2);
		
		User hanuma = new User("Hunuma","Hanuma123",roles);
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/Coder").hasAuthority("Coder")
		.and()
		.formLogin().loginPage("/CustomLogin").loginProcessingUrl("/process-login").permitAll()
		.and()
		.httpBasic()
		.and().logout()
		.and()
		.exceptionHandling().accessDeniedPage("/access");
	}
	
}
