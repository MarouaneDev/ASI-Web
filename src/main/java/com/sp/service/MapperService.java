package com.sp.service;

import com.sp.model.User;
import com.sp.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public User DTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setOwnedCards(userDTO.getOwnedCards());
        user.setWalletAmount(userDTO.getWalletAmount());
        return user;
    }

    public UserDTO UserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setOwnedCards(user.getOwnedCards());
        userDTO.setWalletAmount(user.getWalletAmount());
        return userDTO;
    }
}
