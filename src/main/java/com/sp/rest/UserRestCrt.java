package com.sp.rest;

import com.sp.model.User;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserRestCrt {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public String userList() {
        List<User> listUser = userService.listUser();
        StringBuilder s = new StringBuilder();
        for(User user : listUser) {
            s.append(user.toString()).append("\n");
        }
        return s.toString();
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }
}
