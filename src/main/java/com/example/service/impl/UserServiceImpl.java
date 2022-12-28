package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private final UserRepository repository;
	
	/** ユーザー登録 */
	@Override
	public boolean signup(User user) {
		var result = false;
		try {
			repository.save(user);
			result = true;
		} catch (Exception e) {
			log.error("ユーザー登録失敗: {}", e);
		}
		return result;
	}

}
