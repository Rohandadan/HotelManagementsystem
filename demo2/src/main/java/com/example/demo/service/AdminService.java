package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Room;
import com.example.demo.repos.AdminRepository;
import com.example.demo.repos.RoomRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoomRepository roomRepo;
    
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public Admin findAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

	public List<Room> findByAvailableTrue() {
		return roomRepo.findByIsAvailableTrue();
	}



	

	

}
