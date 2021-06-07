package com.asi.service.auth.AuthService.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class UserToken {
    @Id
    @GeneratedValue

    protected int id;
    //protected int userId;
    @NotNull
    protected String email;
    @NotNull
    protected String token;

    public int getId() {
        return id;
    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    /**
     * @return email string
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email string
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return token string
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token string
     */
    public void setToken(String token) {
        this.token = token;
    }
}
