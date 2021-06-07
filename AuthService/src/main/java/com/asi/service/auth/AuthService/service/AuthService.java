package com.asi.service.auth.AuthService.service;


import com.asi.service.auth.AuthService.model.UserToken;
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

    public UserToken findByToken(String userToken) {
        return userTokenRepository.findByToken(userToken);
    }

    public UserToken addUserToken(UserToken userToken) {
        try {
            UserToken user = userTokenRepository.findByEmail(userToken.getEmail());

            if (user != null) {
                user.setToken(generateNewToken());
                userTokenRepository.save(user);
                return user;
            }

            userToken.setToken(generateNewToken());
            userTokenRepository.save(userToken);
        } catch (Exception e) {
            return new UserToken();
        }
        return userToken;
    }

    public List<UserToken> list() {
        return (List<UserToken>) userTokenRepository.findAll();
    }

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }



}
