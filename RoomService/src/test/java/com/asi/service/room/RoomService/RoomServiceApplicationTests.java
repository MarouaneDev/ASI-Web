package com.asi.service.room.RoomService;

import com.asi.service.room.RoomService.model.Room;
import com.asi.service.room.RoomService.model.User;
import com.asi.service.room.RoomService.service.RoomService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RoomServiceApplicationTests {

	@Autowired
	RoomService roomService = new RoomService();

	List<User> lista = new LinkedList<User>();

	Room room = new Room(1, "Da hood", lista);

	User user = new User("Vato", "Vato@loco.hood");

	@Test
	@Order(1)
	void create_list_roomTest() {
		roomService.createRoom(room);
		assertEquals(room.getRoomName(), roomService.listRoom().get(0).getRoomName());
	}

	@Test
	@Order(2)
	void join_exit_roomTest(){
		roomService.joinRoom(room, user);
		assertEquals(user.getUsername(), room.getPlayerList().get(0).getUsername());
		roomService.exitRoom(room, user);
		assertEquals(0, room.getPlayerList().size());
	}

}