package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.BookingRequest;

@Controller
public class HotelManagement {
	@GetMapping("/home")
	public String home() {
		return "edit.html";
	}
	
	@GetMapping("/Room register")
	public String roomregister(ModelMap model ) {
		model.put("bookingRequest", new BookingRequest());
		return "Bookingroom.html";
		
	}
	
	
	
	
	

}



