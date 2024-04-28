
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entity.Booking;
import com.example.demo.repos.BookingRepository;
import com.example.demo.repos.PaymentRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public RedirectView saveBooking(Booking booking) {
        // Save the booking
        bookingRepository.save(booking);

        // Update payment status after registration
        bookingRepository.updatePaymentStatus(booking.getId());
        return new RedirectView("/success");
    }
    
    
}
