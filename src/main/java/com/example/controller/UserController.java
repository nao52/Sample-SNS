package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.user.SignupForm;
import com.example.model.User;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {
	
	@Autowired
	private UserService service;

	@GetMapping("/signup")
	public String showSignup(Model model) {
		model.addAttribute("title", "Sign up");
		return "users/new";
	}
	
	@PostMapping("/signup")
	public String signup(@Validated @ModelAttribute("form") SignupForm signupForm, 
			BindingResult result,
			Model model, RedirectAttributes redirect) {
		
		if (result.hasErrors()) {
			log.info("入力値エラー: {}" , signupForm);
			model.addAttribute("failedMessage", "ユーザー登録に失敗しました");
			return showSignup(model);
		}
		
		var user = new User();
		if (!service.signup(user)) {
			model.addAttribute("failedMessage", "ユーザー登録に失敗しました");
			return showSignup(model);
		}
		redirect.addFlashAttribute("successMessage", "ユーザー登録に成功しました");
		return "redirect:/";
	}
	
}
