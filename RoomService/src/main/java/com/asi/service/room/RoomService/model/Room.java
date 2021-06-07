package com.asi.service.room.RoomService.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private int id;
    private String roomName;
    @OneToMany
    private List<User> playerList;

    public Room(){

    }


    public Room(int id, String roomName, List<User> playerList) {
        this.id = id;
        this.roomName = roomName;
        this.playerList = playerList;
    }

    public String getRoomName() {
        return roomName;
    }

    public List<User> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<User> playerList) {
        this.playerList = playerList;
    }
}
