package com.asi.service.user.UserService.service;

import com.asi.service.user.UserService.model.User;
import com.asi.service.user.UserService.model.UserDTO;
import com.asi.service.user.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final String authServiceURL = "http://asi-auth-service:8083/";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();

    @Autowired
    UserRepository uRepository;
    @Autowired
    MapperService mapperService;

    public User login(String username, String password) {
        User user = uRepository.findByEmailAndPassword(username, password);
        user.setToken(generateNewToken(user.getEmail()));
        try {
            uRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return uRepository.findByUsername(username);
    }

    public User getUser(int userId) {
        return uRepository.findById(userId);
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
            e.printStackTrace();
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

    public static String generateNewToken(String email) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>("{\n" +
                "    \"email\": \""+email+"\"\n" +
                "}", headers);
        return restTemplate.postForObject(authServiceURL+"generate-token", entity, String.class);
    }

    public boolean loginCheck(String token) {
        String response = this.authLoginCheck(token);
        return Boolean.parseBoolean(response);
    }

    /**
     *
     * @param token string
     * @return string token
     */
    private String authLoginCheck(String token) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>("{\n" +
                "    \"token\": \""+token+"\"\n" +
                "}", headers);
        return restTemplate.postForObject(authServiceURL+"login-check", entity, String.class);
    }

    public User findByToken(String token) {
        return uRepository.findByToken(token);
    }
}
