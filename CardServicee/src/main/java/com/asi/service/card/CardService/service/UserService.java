package com.asi.service.card.CardService.service;

import com.asi.service.card.CardService.model.User;
import com.asi.service.card.CardService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository uRepository;

    public User getUser(String username) {
        User user = uRepository.findByUsername(username);
        return user;
    }

    public User getUser(int userId) {
        User user = uRepository.findById(userId);
        return user;
    }

}
