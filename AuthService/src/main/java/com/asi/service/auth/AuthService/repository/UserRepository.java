package com.asi.service.auth.AuthService.repository;


import com.asi.service.auth.AuthService.model.UserToken;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserToken, Integer> {
    /**
     * @param token token as string
     * @return UserToken object
     */
    public UserToken findByToken(String token);

    /**
     * @param email string
     * @return UserToken object
     */
    public UserToken findByEmail(String email);
}
