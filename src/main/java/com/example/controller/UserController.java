package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/signup")
	public String showSignup(Model model) {
		model.addAttribute("title", "Sign up");
		return "users/new";
	}
	
}
