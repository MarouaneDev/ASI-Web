package com.asi.service;

import com.asi.model.User;
import com.asi.model.UserDTO;
import com.asi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class UserService {

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    @Autowired
    UserRepository uRepository;
    @Autowired
    MapperService mapperService;
    public User login(String username, String password) {
        User user = uRepository.findByEmailAndPassword(username, password);
        return user;
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
            user.setToken(generateNewToken());
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

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public boolean loginCheck(User user) {
        User userToCheck = uRepository.findByToken(user.getToken());
        return userToCheck != null;
    }

    public User findByToken(String token) {
        return uRepository.findByToken(token);
    }
}
