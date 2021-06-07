package com.asi.service.user.UserService.rest;

import com.asi.service.user.UserService.model.User;
import com.asi.service.user.UserService.model.UserDTO;
import com.asi.service.user.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserRestCrt {

    @Autowired
    UserService userService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<UserDTO> userList() {
        return userService.listUser();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        User userToCheck = userService.login(user.getEmail(), user.getPassword());
        return userToCheck.getToken();
    }

    @RequestMapping(value="/login-check", method = RequestMethod.POST)
    public boolean loginCheck(@RequestBody User user) {
        return userService.loginCheck(user.getToken());
    }

    @RequestMapping(value="/token", method = RequestMethod.POST)
    public User getUserByToken(@RequestBody User user) {
        return userService.findByToken(user.getToken());
    }
}