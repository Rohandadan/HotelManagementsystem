package com.example.demo.models;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Payment;
import com.example.demo.repos.BookingRepository;
import com.example.demo.repos.PaymentRepository;

@Controller
public class PaymentRequest {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/payment")
    @ResponseBody
    public String makePayment(Payment payment,@RequestParam int bookingId, @RequestParam double roomPrice) {
        // Validate payment request
//        if (paymentRequest == null) {
//            throw new IllegalArgumentException("Payment request is null");
//        }
//       
//        if (paymentRequest.getBookingId() == null || (Integer) paymentRequest.getBookingId() <= 0) {
//        	throw new IllegalArgumentException("Invalid booking ID");
//        }
    	
    	payment.setAmount(roomPrice);
    	payment.setPayment_date(new Date(System.currentTimeMillis()));
    	
        // Update booking status in the database
        Booking booking = bookingRepository.findById((long) bookingId)
            .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        
        payment.setBooking(booking);
        paymentRepository.save(payment);
        booking.setPaymentStatus("Paid"); // Assuming you have a field for payment status in the Booking entity
        bookingRepository.save(booking);

        return "Payment successful!";
    }
    
    @GetMapping("/paymentPage")
    public String showPaymentPage(@RequestParam int bookingId, @RequestParam double roomPrice, @ModelAttribute Payment payment, ModelMap model) {
       model.put("bookingId", bookingId);
       model.put("roomPrice", roomPrice);
       
        return "Payment";
    }

	private Object getBookingId() {
		// TODO Auto-generated method stub
		return null;
	}
}
