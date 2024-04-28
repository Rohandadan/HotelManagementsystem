package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Room;
import com.example.demo.exceptions.InvalidDetailsException;
import com.example.demo.models.BookingRequest;
import com.example.demo.repos.BookingRepository;
import com.example.demo.service.RoomService;



@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/bookroom")
    public String bookRoom(BookingRequest bookingRequest, Model model) {
    	try {
    		int roomNumber = roomService.findAvailableRoomNumber( bookingRequest.getIsAcRoom(), bookingRequest.getAdults(), bookingRequest.getChildren());
            // Create a new Booking object
            Booking booking = new Booking();
            booking.setRoomNumber(roomNumber);
            booking.setGuestName(bookingRequest.getName());
            booking.setPhoneNumber(bookingRequest.getPhoneNumber());
            if(bookingRequest.getPhoneNumber().length()!=10) {
            	throw new InvalidDetailsException("Invalid Phone Number");
            }
            
            if(!bookingRequest.getEmail().matches("^\\S+@gmail\\.com$")) {
            	throw new InvalidDetailsException("Invalid Email Id");
            }
            booking.setEmail(bookingRequest.getEmail());
//            booking.setFromDate(bookingRequest.getFromDate());
//            booking.setToDate(bookingRequest.getToDate());
            booking.setTotalAmount(bookingRequest.getTotalAmount());
            booking.setPaymentStatus("Pending"); // Set an appropriate payment status

            // Calculate room price based on AC or non-AC selection
            double roomPrice = (bookingRequest.getIsAcRoom()) ? 1000.0 : 500.0;
            booking.setTotalAmount(roomPrice);

            // Save booking details to the database
            bookingRepository.save(booking);

            // Update room availability status (Assuming the room is now unavailable after booking)
            Room bookedRoom = roomService.findByRoomNumber(roomNumber);
            bookedRoom.setIsAvailable(0);
            roomService.saveRoom(bookedRoom);
            
           

            // Redirect to a success page
            return "redirect:/paymentPage?bookingId=" + booking.getId() + "&roomPrice=" + roomPrice;
            
    	}
    	catch(InvalidDetailsException e) {
    		model.addAttribute("invalid", e.getMessage());
    		return "Bookingroom.html";
    	}
    	
    }
}
