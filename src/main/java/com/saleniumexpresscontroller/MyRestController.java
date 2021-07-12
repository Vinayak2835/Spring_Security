package com.saleniumexpresscontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyRestController {
	
	
	@GetMapping("/greet/{yourName}")
	@ResponseBody
	public String greet(@PathVariable("yourName") String yourName) {
		
		return "Hello boss"+yourName;
	}

}
