package com.asi.service.room.RoomService.rest;

import com.asi.service.room.RoomService.model.Room;
import com.asi.service.room.RoomService.model.User;
import com.asi.service.room.RoomService.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomRestCrt {

    @Autowired
    RoomService roomService;

    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<Room> roomList() {
        return roomService.listRoom();
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public void createRoom(@RequestBody Room room) {
        roomService.createRoom(room);
    }

    @RequestMapping(value="/join", method = RequestMethod.POST)
    public void joinRoom(@RequestBody Room room, User user) {
        roomService.joinRoom(room, user);
    }

    @RequestMapping(value="/exit", method = RequestMethod.POST)
    public void exitRoom(@RequestBody Room room, User user) {
        roomService.exitRoom(room, user);
    }

}