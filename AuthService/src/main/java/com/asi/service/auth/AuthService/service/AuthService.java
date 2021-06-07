package com.asi.service.auth.AuthService.service;


import com.asi.service.auth.AuthService.model.User;
import com.asi.service.auth.AuthService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;


@Service
public class AuthService {

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    @Autowired
    UserRepository userTokenRepository;
    public boolean loginCheck(String userToken) {
        return userTokenRepository.findByToken(userToken) != null;
    }

    public User findByToken(String userToken) {
        return userTokenRepository.findByToken(userToken);
    }

    public boolean addUser(User user) {
        try {
            userTokenRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public User generateToken(User user) {
        if (userTokenRepository.findByEmail(user.getEmail()) != null) {
            return user;
        }

        user.setToken(generateNewToken());
        try {
            userTokenRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<User> list() {
        return (List<User>) userTokenRepository.findAll();
    }

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
