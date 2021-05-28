package com.asi.service.user.UserService.service;

import com.asi.service.user.UserService.model.User;
import com.asi.service.user.UserService.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public User DTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setOwnedCards(userDTO.getOwnedCards());
        user.setWalletAmount(userDTO.getWalletAmount());
        user.setToken(userDTO.getToken());
        return user;
    }

    public UserDTO UserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setOwnedCards(user.getOwnedCards());
        userDTO.setWalletAmount(user.getWalletAmount());
        userDTO.setToken(user.getToken());
        return userDTO;
    }
}
