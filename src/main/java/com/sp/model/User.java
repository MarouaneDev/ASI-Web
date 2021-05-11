package com.sp.model;

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
    private int id;
    private String username;
    private String email;
    private String password;
    @OneToMany
    private List<Carte> ownedCards;
    private long walletAmount;

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

    public long getWalletAmount() {
        return walletAmount;
    }

    public void decreaseWallet(long amount) {
        this.walletAmount -= amount;
    }

    public void increaseWallet(long amount) {
        this.walletAmount += amount;
    }

    public void setWalletAmount(long walletAmount) {
        this.walletAmount = walletAmount;
    }

    public String getPassword() {
        return password;
    }

//    public List<Carte> getOwnedCards() {
//        return ownedCards;
//    }
//
//    public void setOwnedCards(List<Carte> ownedCards) {
//        this.ownedCards = ownedCards;
//    }

    public void removeOwnedCard(Carte carte) {
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
               // ", ownedCards=" + ownedCards +
                ", walletAmount=" + walletAmount +
                '}';
    }
}
