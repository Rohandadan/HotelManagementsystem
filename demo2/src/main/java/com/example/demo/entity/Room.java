package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rooms")
public class Room {
	@Id
	private int roomNumber;
	private int isAcRoom;
	private int capacityAdults;
	private int capacityChildren;
	private int isAvailable;
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getIsAcRoom() {
		return isAcRoom;
	}
	public void setIsAcRoom(int isAcRoom) {
		this.isAcRoom = isAcRoom;
	}
	public int getCapacityAdults() {
		return capacityAdults;
	}
	public void setCapacityAdults(int capacityAdults) {
		this.capacityAdults = capacityAdults;
	}
	public int getCapacityChildren() {
		return capacityChildren;
	}
	public void setCapacityChildren(int capacityChildren) {
		this.capacityChildren = capacityChildren;
	}
	public int getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(int b) {
		this.isAvailable = b;
	}
	
	public Room() {
		
	}
	public Room(int roomNumber, int isAcRoom, int capacityAdults, int capacityChildren, int isAvailable) {
		super();
		this.roomNumber = roomNumber;
		this.isAcRoom = isAcRoom;
		this.capacityAdults = capacityAdults;
		this.capacityChildren = capacityChildren;
		this.isAvailable = isAvailable;
	}
	
	
	

}