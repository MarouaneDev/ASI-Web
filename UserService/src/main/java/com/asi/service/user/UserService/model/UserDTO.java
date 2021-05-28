package com.asi.service.user.UserService.model;

import java.util.List;

public class UserDTO {
    private String username;
    private List<Integer> ownedCards;
    private long walletAmount;
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(List<Integer> ownedCards) {
        this.ownedCards = ownedCards;
    }

    public long getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(long walletAmount) {
        this.walletAmount = walletAmount;
    }

    public String getToken() { return token; }

    public void setToken(String token) {
        this.token = token;
    }
}
