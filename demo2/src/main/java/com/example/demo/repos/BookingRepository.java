package com.example.demo.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Booking;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByGuestName(String guestName);

    @Modifying
    @Query("UPDATE Booking b SET b.paymentStatus = 'Paid' WHERE b.id = :id")
    void updatePaymentStatus(@Param("id") Long bookingId);

   
}
