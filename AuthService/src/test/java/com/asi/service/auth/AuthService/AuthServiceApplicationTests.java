package com.asi.service.auth.AuthService;

import com.asi.service.auth.AuthService.model.User;
import com.asi.service.auth.AuthService.repository.UserRepository;
import com.asi.service.auth.AuthService.service.AuthService;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthServiceApplicationTests {

	@Autowired
	AuthService authService;

	@Autowired
	UserRepository userTokenRepository;

	User user = new User();

	@Test
	@Order(1)
	void addUser_GenerateTokenTest() {
		user.setEmail("daryl@laposte.net");
		assertEquals(user, authService.generateToken(user));
		assertTrue(authService.addUser(user));
	}

	@Test
	@Order(2)
	void findByToken_And_EmailTest(){
		user = userTokenRepository.findByEmail("daryl@laposte.net");
		assertEquals(user.getEmail(), authService.findByToken(user.getToken()).getEmail());
	}

	@Test
	@Order(3)
	void loginCheckTest(){
		user = userTokenRepository.findByEmail("daryl@laposte.net");
		assertTrue(authService.loginCheck(user.getToken()));
		assertFalse(authService.loginCheck(null));
	}

}
