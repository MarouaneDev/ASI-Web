package com.asi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
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

    /**
     * @param username
     * @param email
     * @param password
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.ownedCards = new ArrayList<>();
        this.walletAmount = 0;
    }
    /**
     * @param username
     * @param email
     * @param password
     * @param token
     */
    public User(String username, String email, String password, String token) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.ownedCards = new ArrayList<>();
        this.walletAmount = 0;
        this.token = token;
    }

    /**
     *
     * @param username
     * @param email
     * @param password
     * @param walletAmount
     */
    public User(String username, String email, String password, long walletAmount) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.ownedCards = new ArrayList<>();
        this.walletAmount = walletAmount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() { return token; }

    public void setToken(String token) {
        this.token = token;
    }

    public long getWalletAmount() {
        return walletAmount;
    }

    public long decreaseWallet(long amount) {
        this.walletAmount -= amount;
        return this.walletAmount;
    }

    public long increaseWallet(long amount) {
        this.walletAmount += amount;
        return this.walletAmount;
    }

    public void setWalletAmount(long walletAmount) {
        this.walletAmount = walletAmount;
    }

    public String getPassword() {
        return password;
    }

    public void removeOwnedCard(Carte carte) {
        if (!this.ownedCards.contains(carte))
        this.ownedCards.remove(carte);
    }

    public void addOwnedCard(Carte carte) {
        this.ownedCards.add(carte);
    }

    public List<Carte> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(List<Carte> ownedCards) {
        this.ownedCards = ownedCards;
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
