package com.asi.service.auth.AuthService;

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
    public boolean loginCheck(@RequestBody UserToken userToken) {
        return authService.loginCheck(userToken.getToken());
    }

    @RequestMapping(value="/token", method = RequestMethod.POST)
    public UserToken getUserByToken(@RequestBody UserToken userToken) {
        return authService.findByToken(userToken.getToken());
    }

    @RequestMapping(value="/generate-token", method= RequestMethod.POST)
    public String generateToken(@RequestBody UserToken userToken) {
        return authService.addUserToken(userToken).getToken();
    }
    @RequestMapping("/list")
    public List<UserToken> listUserToken() {
        return authService.list();
    }

}
