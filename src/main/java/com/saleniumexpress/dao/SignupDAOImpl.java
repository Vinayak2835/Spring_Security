package com.saleniumexpress.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.saleniumexpress.dto.SignupDTO;

@Repository
public class SignupDAOImpl implements SignupDAO{
    
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveUser(SignupDTO signUpDTO) {
	
		String sql ="insert into users values(?,?,?)";
		String sql1 = "insert into authorities values(?,?)";
		
		jdbcTemplate.update(sql,signUpDTO.getUsername(),signUpDTO.getPassword(),1);
		jdbcTemplate.update(sql1,signUpDTO.getUsername(),"Admin");
		
		
		
	}

}
