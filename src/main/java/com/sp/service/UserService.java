package com.sp.service;

import com.sp.model.User;
import com.sp.model.UserDTO;
import com.sp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository uRepository;
    @Autowired
    MapperService mapperService;
    public boolean login(String username, String password) {
        User user = uRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }

    public UserDTO getUserDTO(String username) {
        User user = uRepository.findByUsername(username);
        return mapperService.UserToDTO(user);
    }

    public UserDTO getUserDTO(int userId) {
        User user = uRepository.findById(userId);
        return mapperService.UserToDTO(user);
    }

    public User getUser(String username) {
        User user = uRepository.findByUsername(username);
        return user;
    }

    public User getUser(int userId) {
        User user = uRepository.findById(userId);
        return user;
    }

    public String addUser(String username, String email, String password) {
        User user = new User(username, email, password);
        uRepository.save(user);
        return user.toString();
    }

    public boolean addUser(User user) {
        try {
            uRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<UserDTO> listUser() {
        List<UserDTO> usersDTO = new ArrayList<>();
        List<User> users = (List<User>) uRepository.findAll();
        for(User user : users) {
            UserDTO userDTO = mapperService.UserToDTO(user);
            usersDTO.add(userDTO);
        }
        return usersDTO;
    }
}
