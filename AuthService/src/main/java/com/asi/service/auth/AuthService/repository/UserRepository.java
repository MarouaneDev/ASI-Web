package com.asi.service.auth.AuthService.repository;


import com.asi.service.auth.AuthService.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * @param token token as string
     * @return UserToken object
     */
    public User findByToken(String token);

    /**
     * @param email string
     * @return UserToken object
     */
    public User findByEmail(String email);
}
