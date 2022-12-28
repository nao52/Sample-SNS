package com.example.repository;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.helper.TestHelper;
import com.example.model.User;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class UserRepositoryTest extends TestHelper {
	
	@Autowired
	UserRepository repository;
	
	/** テストユーザーの用意 */
	User user = new User();
	
	@BeforeEach
	void setUp() throws Exception {
		user.setName("Example User");
		user.setEmail("user@example.com");
		user.setPassword("password");
	}
	
//	@Test
//	@DisplayName("ユーザー登録が成功したとき、ユーザー数が1つ増える")
//	void signup_is_success() {
//		var beforeCount = repository.count();
//		repository.save(user);
//		var afterCount = repository.count();
//		assertEquals(beforeCount + 1, afterCount);
//	}
//
//	@Test
//	@DisplayName("名前がNULLのとき、エラーになる")
//	void name_should_be_present() {
//		user.setName(null);
//		assertThrows(Exception.class, () -> repository.save(user));
//	}
//	
//	@Test
//	@DisplayName("メールアドレスがNULLのとき、エラーになる")
//	void email_should_be_present() {
//		assertThrows(Exception.class, () -> user.setEmail(null));
//	}
//	
//	@Test
//	@DisplayName("名前が51文字以上のとき、エラーになる")
//	void name_should_not_be_too_long() {
//		user.setName(createString(51));
//		assertThrows(Exception.class, () -> repository.save(user));
//	}
//	
//	@Test
//	@DisplayName("メールアドレスが256文字以上のとき、エラーになる")
//	void email_should_not_be_too_long() throws Exception {
//		user.setEmail(createString(244) + "@example.com");
//		assertThrows(Exception.class, () -> repository.save(user));
//	}
//	
//	@Test
//	@DisplayName("メールアドレスが重複しているとき、エラーになる")
//	void email_address_should_be_unique() {
//		repository.save(user);
//		var beforeCount = repository.count();
//		repository.save(user);
//		var afterCount = repository.count();
//		assertEquals(beforeCount, afterCount);
//	}
//	
//	@Test
//	@DisplayName("パスワードがNULLのとき、エラーになる")
//	void password_should_be_present() {
//		user.setPassword(null);
//		assertThrows(Exception.class, () -> repository.save(user));
//	}

}
