package com.asi.service.auth.AuthService.rest;

import com.asi.service.auth.AuthService.service.AuthService;
import com.asi.service.auth.AuthService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @RequestMapping(value="/login-check", method = RequestMethod.POST)
    public boolean loginCheck(@RequestBody User user) {
        return authService.loginCheck(user.getToken());
    }

    @RequestMapping(value="/token", method = RequestMethod.POST)
    public User getUserByToken(@RequestBody User user) {
        return authService.findByToken(user.getToken());
    }

    @RequestMapping(value="/add-user", method = RequestMethod.POST)
    public boolean addUser(@RequestBody User user) {
        return authService.addUser(user);
    }

    @RequestMapping(value="/generate-token", method= RequestMethod.POST)
    public String generateToken(@RequestBody User user) {
        return authService.generateToken(user).getToken();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> listUserToken() {
        return authService.list();
    }
}
