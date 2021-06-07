package com.asi.service.room.RoomService.service;

import com.asi.service.room.RoomService.model.Room;
import com.asi.service.room.RoomService.repository.RoomRepository;
import com.asi.service.room.RoomService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<Room> listRoom() {
        Iterable<Room> rooms = roomRepository.findAll();
        long size = rooms.spliterator().getExactSizeIfKnown();
        if(size > 0) {
            List<Room> allRooms = new ArrayList<>();
            rooms.forEach(allRooms::add);
            return allRooms;
        } else {
            return null;
        }
    }

    public void createRoom(Room room) {
        Room createdRoom=roomRepository.save(room);
        System.out.println(createdRoom);
    }

    public void joinRoom(Room room, User user){
        List<User> users = room.getPlayerList();
        users.add(user);
        room.setPlayerList(users);
        System.out.println(user.getUsername()+" joined the room "+room.getRoomName());
    }

    public void exitRoom(Room room, User user){
        List<User> list = room.getPlayerList();
        for (Iterator<User> iterator = list.iterator(); iterator.hasNext();) {
            User userToExit= iterator.next();
            if (userToExit.getEmail().equals(user.getEmail())) {
                iterator.remove();
                System.out.println(user.getUsername()+" has left the room.");
            }
        }
    }
}
