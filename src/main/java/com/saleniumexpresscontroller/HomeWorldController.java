package com.saleniumexpresscontroller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeWorldController {
    
	@GetMapping("/home")
	public String HelloWorldController(Model model, Principal principal) {
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		//String userName = authentication.getName().toString();
		String userName = principal.getName();
		System.out.println(userName);
	    model.addAttribute("userName",userName);
	    //model.addAttribute("roles", authorities);
		
		return "home";
	}
    
	@GetMapping("/Trainer")
	public String showTrainerDashBoard() {

		return "Trainee-DashBoard";
	}
	
	@GetMapping("/Coder")
	public String  showCoderDashBoard() {

		return "Coder-DashBoard";
	}
	
	@GetMapping("/access")
	public String acceessDenied() {
		
		return "access-denied";
	}
}
