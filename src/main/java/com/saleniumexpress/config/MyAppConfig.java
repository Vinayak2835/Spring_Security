package com.saleniumexpress.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"com.saleniumexpresscontroller","com.saleniumexpress.config","com.saleniumexpress.dto","com.saleniumexpress.dao"})
public class MyAppConfig {
  
  @Bean
  public InternalResourceViewResolver resolver() {
	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/view/");
      resolver.setSuffix(".jsp");
	  return resolver;
  }
     @Bean
     public JdbcTemplate jdbcTemplate() {
    	 JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource());
    	 
    	 return jdbcTemplate;
     }
    
     @Bean
    public  DataSource datasource() {
    	
    	DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    	driverManagerDataSource.setUsername("root");
    	driverManagerDataSource.setPassword("root");
    	driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/evening");
    	driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	
    	return driverManagerDataSource;
    }
     
     @Bean
     public PasswordEncoder passwordEncoder() {
    	// return NoOpPasswordEncoder.getInstance();
    	 
    	 return new BCryptPasswordEncoder();
     }
  }
