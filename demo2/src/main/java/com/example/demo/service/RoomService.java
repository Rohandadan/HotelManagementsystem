package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Room;
import com.example.demo.repos.RoomRepository;

@Service
public class RoomService {
	
	@Autowired
	RoomRepository roomRepo;

	public void saveRoom(Room bookedRoom) {
		roomRepo.save(bookedRoom);
		
	}

	public Room findByRoomNumber(int roomNumber) {
		System.out.println(roomNumber);
		List<Room> room = roomRepo.findByRoomNumber(roomNumber);
		System.out.println(room);
		return room.get(0);
	}

	
	public int findAvailableRoomNumber(boolean isAcRoom, int adults, int children) {
		List<Room> rooms = roomRepo.findAvailableRooms(isAcRoom?1:0, adults, children);
		if(rooms.size()==0) {
			return -1;
		}
		else {
			return rooms.get(0).getRoomNumber();
		}
	}

}
