package com.example.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.helper.TestHelper;

class UserTest extends TestHelper {
	
	/** テストユーザーの用意 */
	User user = new User();
	
	@BeforeEach
	void setUp() throws Exception {
		user.setName("Example User");
		user.setEmail("user@example.com");
		user.setPassword("password");
	}

	@Test
	@DisplayName("ユーザーの有効性を確認")
	void should_be_valid() throws Exception {
		assertNotNull(user);
	}
	
	@Test
	@DisplayName("名前がないとき、エラーが発生する")
	void name_should_be_present() throws Exception {
		assertThrows(Exception.class, () -> user.setName(""));
	}
	
	@Test
	@DisplayName("メールアドレスがないとき、エラーが発生する")
	void email_should_be_present() throws Exception {
		assertThrows(Exception.class, () -> user.setEmail(""));
	}
	
	@Test
	@DisplayName("パスワードがないとき、エラーが発生する")
	void password_should_be_present() throws Exception {
		assertThrows(Exception.class, () -> user.setPassword(""));
	}
	
	@Test
	@DisplayName("名前が51文字以上のとき、エラーが発生する")
	void name_should_not_be_too_long() throws Exception {
		var name = createString(51);
		assertThrows(Exception.class, () -> user.setName(name));
	}
	
	@Test
	@DisplayName("メールアドレスが256文字以上のとき、エラーが発生する")
	void email_should_not_be_too_long() throws Exception {
		var email = createString(244) + "@example.com";
		assertThrows(Exception.class, () -> user.setEmail(email));
	}
	
	@Test
	@DisplayName("パスワードが6文字未満のとき、エラーが発生する")
	void password_should_have_a_minimum_length() throws Exception {
		var password = createString(5);
		assertThrows(Exception.class, () -> user.setPassword(password));
	}
	
	@Test
	@DisplayName("メールアドレスはすべて小文字として扱われる")
	void email_address_should_be_saved_as_lowercase() throws Exception {
		var mixedCaseEmail = "Foo@ExAMPle.CoM";
		user.setEmail(mixedCaseEmail);
		var expected = mixedCaseEmail.toLowerCase();
		assertEquals(expected, user.getEmail());
	}

}
