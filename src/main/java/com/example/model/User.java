package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, length = 255, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(nullable = false)
	private LocalDateTime updatedAt = LocalDateTime.now();
	
	public User() {};
	
	public User(String name, String email, String password) throws Exception {
		this.setName(name);
		this.setEmail(email);
		this.setPassword(password);
	}
		
	public void setName(String name) throws Exception {
		if (name.isBlank()) {
			throw new Exception("Nullは許可されていません");
		} else if (name.length() >= 51) {
			throw new Exception("51文字以上は許可されていません");
		}
		this.name = name;
	}

	public void setEmail(String email) throws Exception {
		if (email.isBlank()) {
			throw new Exception("Nullは許可されていません");
		} else if (email.length() >= 256) {
			throw new Exception("256文字以上は許可されていません");
		}
		this.email = email.toLowerCase();
	}

	public void setPassword(String password) throws Exception {
		if (password.isBlank()) {
			throw new Exception("Nullは許可されていません");
		} else if (password.length() < 6) {
			throw new Exception("最小文字数は6文字です");
		}
		this.password = password;
	}

}
