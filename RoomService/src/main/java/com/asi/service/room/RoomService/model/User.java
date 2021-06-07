package com.asi.service.room.RoomService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    protected int id;
    protected String username;
    protected String email;
    protected String password;
    protected String token;
    @OneToMany
    protected List<Carte> ownedCards;
    protected long walletAmount;

    public User() { }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ownedCards=" + ownedCards  + '\'' +
                ", walletAmount=" + walletAmount  + '\'' +
                ", token=" + token +
                '}';
    }
}
