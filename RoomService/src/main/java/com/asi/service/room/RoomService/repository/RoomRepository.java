package com.asi.service.room.RoomService.repository;

import com.asi.service.room.RoomService.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    public Room findByRoomName(String roomName);
}
