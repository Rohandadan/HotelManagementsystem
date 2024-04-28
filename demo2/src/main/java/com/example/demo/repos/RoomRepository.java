package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT r FROM Room r WHERE r.isAcRoom = :isAcRoom AND r.capacityAdults >= :adults AND r.capacityChildren >= :children AND r.isAvailable = 1")
    List<Room> findAvailableRooms(@Param("isAcRoom") int isAcRoom, @Param("adults") int adults, @Param("children") int children);
    
    List<Room> findByRoomNumber(int roomNumber);
    List<Room> findByIsAvailableTrue();

}