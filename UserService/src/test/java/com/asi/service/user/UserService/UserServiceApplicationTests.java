package com.asi.service.user.UserService;

import com.asi.service.user.UserService.model.User;
import com.asi.service.user.UserService.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceApplicationTests {

    //Used to populate the database  and test the addUser method
    User user = new User("Daryl69", "daryl69@laposte.net", "darylpwd");
    User user1 = new User("paul", "paul@paul.paul", "paul");
    @Autowired
    UserService userService;

    @BeforeAll
    static void initAll(@Autowired UserService userService){
        userService.addUser("Daryl69", "daryl69@laposte.net", "darylpwd");
        userService.addUser("paul", "paul@paul.paul", "paul");
    }
    /*
	@Test
    @Order(1)
	void addUserTest() {
        assertEquals(user.toString(), userService.addUser(user.getUsername(), user.getEmail(), user.getPassword()));
        assertTrue(userService.addUser(user1));
	}
*/
	@Test
    @Order(1)
    void findByEmailTest(){
        assertEquals(user.getEmail(), userService.getUser(user.getUsername()).getEmail());
        assertEquals(user1.getEmail(), userService.getUser(user1.getUsername()).getEmail());
    }

	@Test
    @Order(2)
    void listUserTest() {
        System.out.println(userService.listUser());
	    assertEquals(2, userService.listUser().size());
    }

    @Test
    @Order(3)
    void loginTest() {
	    assertEquals(user.getToken(), userService.login(user.getUsername(), user.getPassword()));
    }

    @Test
    @Order(4)
    void loginTest_Not_Pass() {
	    assertNull(userService.login("paull", user1.getPassword()));
    }

}
