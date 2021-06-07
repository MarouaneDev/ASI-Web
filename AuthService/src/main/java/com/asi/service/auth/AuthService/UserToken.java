package com.asi.service.auth.AuthService;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
