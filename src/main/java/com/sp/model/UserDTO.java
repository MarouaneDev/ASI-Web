package com.sp.model;

import java.util.List;

public class UserDTO {
    private String username;
    private List<Carte> ownedCards;
    private long walletAmount;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Carte> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(List<Carte> ownedCards) {
        this.ownedCards = ownedCards;
    }

    public long getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(long walletAmount) {
        this.walletAmount = walletAmount;
    }
}
