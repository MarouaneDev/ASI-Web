package com.sp.service;

import com.sp.model.User;
import com.sp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository uRepository;
    public String login(String username, String password) {
        User user = uRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return "User not found";
        }
        return "User connected";
    }

    public String getUser(String username) {
        User user = uRepository.findByUsername(username);
        return user.toString();
    }

    public String addUser(String username, String email, String password) {
        User user = new User(username, email, password);
        uRepository.save(user);
        return user.toString();
    }

    public String addUser(User user) {
        uRepository.save(user);
        return user.toString();
    }

    public List<User> listUser() {
        return (List<User>) uRepository.findAll();
    }
}
