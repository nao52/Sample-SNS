package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPagesController {

	@GetMapping("/")
	public String showHome(Model model) {
		return "static_pages/home";
	}
	
	@GetMapping("/help")
	public String showHelp(Model model) {
		model.addAttribute("title", "Help");
		return "static_pages/help";
	}
	
	@GetMapping("/about")
	public String showAbout(Model model) {
		model.addAttribute("title", "About");
		return "static_pages/about";
	}
	
}
