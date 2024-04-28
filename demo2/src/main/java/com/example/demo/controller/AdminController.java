package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Room;
import com.example.demo.service.AdminService;


@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/main")
    public String showMainPage() {
        return "FirstPage.html";
    }

   
//    @PostMapping("/adminLogin1")
//    public String processAdminLogin1() {
//        return "afteradmin.html";
//    }
//    @PostMapping("/adminLogin2")
//    public String processAdminLogin2() {
//        return "availabilityrooms.html";
//    }
    

    @PostMapping("/customerLogin")
    public String processCustomerLogin() {
        return "login.html";
    }

    @GetMapping("/admin/login")
    public String showAdminLoginPage() {
        return "admin.html";
    }
    
    @PostMapping("/admin/login")
    public String loginAdmin(@RequestParam String username, @RequestParam int password) {
        Admin admin = adminService.findAdminByUsername(username);
        if (admin != null && admin.getPassword() == password) {
            return "afteradmin.html";
        } else {
            return "Invalid username or password!";
        }
    }

    @GetMapping("/customer/login")
    public String showCustomerLoginPage() {
        return "login.html";
    }
    @PostMapping("/afterlogin")
    public String afterlogin() {
        return "edit.html";
    }
    
    @GetMapping("/admin/availability")
    public String showAvailableRooms(Model model) {
        List<Room> availableRooms =  adminService.findByAvailableTrue();
        model.addAttribute("rooms", availableRooms);
        return "availabilityrooms";
    }

    
}
