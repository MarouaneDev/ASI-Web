package com.sp.rest;

import com.sp.model.User;
import com.sp.model.UserDTO;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public boolean login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }
}
