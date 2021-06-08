package com.asi.service.user.UserService;

import com.asi.service.user.UserService.model.User;
import com.asi.service.user.UserService.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceApplicationTests {

    //Used to populate the database  and test the addUser method
    User user = new User("test", "test@test.com", "test");
    User user1 = new User("test1", "test1@test.com", "test1");
    @Autowired
    UserService userService;

	@Test
    @Order(1)
    void findByEmailTest(){
        assertEquals(user.getEmail(), userService.getUser(user.getUsername()).getEmail());
        assertEquals(user1.getEmail(), userService.getUser(user1.getUsername()).getEmail());
    }

	@Test
    @Order(2)
    void listUserTest() {
	    assertEquals(4, userService.listUser().size());
    }
}
