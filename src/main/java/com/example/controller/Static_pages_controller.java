package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Static_pages_controller {

	@GetMapping("/home")
	public String showHome() {
		return "static_pages/home";
	}
	
	@GetMapping("/help")
	public String showHelp() {
		return "static_pages/help";
	}
	
	@GetMapping("/about")
	public String showAbout() {
		return "static_pages/about";
	}
	
}
