package com.example.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.model.User;
import com.example.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {
	
	private final UserRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// テストユーザーの作成
		var name = "Michael Hartl";
		var email = "michael@example.com";
		var password = "password";
		
		if (!repository.existsByEmail(email)) {
			var michael = new User(name, email, password);
			repository.save(michael);						
		}
	}
}
