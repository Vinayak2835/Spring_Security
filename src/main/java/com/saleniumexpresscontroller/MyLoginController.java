package com.saleniumexpresscontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saleniumexpress.dao.SignupDAOImpl;
import com.saleniumexpress.dto.SignupDTO;

@Controller
public class MyLoginController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SignupDAOImpl signupDAOIMPL;
	
	
	@GetMapping("/CustomLogin")
	public String Helloworld() {
		return "login";
	}
	
	@GetMapping("/signUp")
	public String signUp(@ModelAttribute("signupdto") SignupDTO signupDTO) {
		
		return "signup";
	}
	
	@PostMapping("/process-signUp")
	public String processSignUp(SignupDTO signupDTO) {
		
		System.out.println(signupDTO);
		
		String encodedPassword = passwordEncoder.encode(signupDTO.getPassword());
		
		System.out.println(encodedPassword);
		
		signupDAOIMPL.saveUser(signupDTO);
		
		return "redirect:/CustomLogin";
	}
}
