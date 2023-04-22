package com.valid.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valid.entity.Login;

import jakarta.validation.Valid;

@Controller

public class ValidController {
	
	@GetMapping("/login")
	public String page( Model m) {
		m.addAttribute("Login", new Login());
		return "Login";
		
	}
	
	@PostMapping("/process")
	public String process(@Valid @ModelAttribute("Login") Login log,BindingResult result) {
		
		
		if(result.hasErrors())
		{
			
			System.out.println(result);
			return "Login";
		}
		System.out.println(log);
		
		return "success";
	}
	
	

}
