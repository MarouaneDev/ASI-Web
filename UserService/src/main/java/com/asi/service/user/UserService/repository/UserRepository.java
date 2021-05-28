package com.asi.service.user.UserService.repository;

import com.asi.service.user.UserService.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
    public User findById(int userId);
    public User findByUsername(String username);
    public User findByToken(String token);
    public User findByUsernameAndPassword(String username, String password);
    public User findByEmailAndPassword(String email, String password);
}
