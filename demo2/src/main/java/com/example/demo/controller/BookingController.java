package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Booking;
import com.example.demo.repos.BookingRepository;

import java.util.List;
@Controller
public class BookingController { 
	@Autowired
	private BookingRepository bookingRepository;     
	@GetMapping("/admin/customerdetails")
	public String showCustomerDetails(Model model) {  
		List<Booking> bookings = bookingRepository.findAll();   
		model.addAttribute("bookings", bookings);       
		return "customerdetails";
	}
}