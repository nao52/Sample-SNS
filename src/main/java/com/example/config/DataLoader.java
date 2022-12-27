package com.example.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.model.Users;
import com.example.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements ApplicationRunner {
	
	private final UsersRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// テストユーザーの作成
		var name = "Michael Hartl";
		var email = "michael@example.com";
		
		if (!repository.existsByEmail(email)) {
			var michael = new Users();
			michael.setName(name);
			michael.setEmail(email);
			repository.save(michael);						
		}
	}
}
