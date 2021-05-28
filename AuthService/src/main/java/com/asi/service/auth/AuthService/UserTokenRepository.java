package com.asi.service.auth.AuthService;


import com.asi.service.auth.AuthService.UserToken;
import org.springframework.data.repository.CrudRepository;


public interface UserTokenRepository extends CrudRepository<UserToken, Integer> {
    public UserToken findByToken(String token);
    public UserToken findByUserId(int userId);
}
