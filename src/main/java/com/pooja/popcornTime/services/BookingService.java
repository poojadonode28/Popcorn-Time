package com.jatin.popcornTime.services;

import com.jatin.popcornTime.dtos.CreateBookingDTO;
import com.jatin.popcornTime.models.Booking;
import com.jatin.popcornTime.models.Customer;
import com.jatin.popcornTime.models.ShowSeat;
import com.jatin.popcornTime.repositories.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@AllArgsConstructor
public class BookingService {

    private final ShowSeatService showSeatService;

    private final CustomerService customerService;

    private final BookingRepository bookingRepository;

    private final Lock lock = new ReentrantLock(); // mutex

    public Booking bookTicket(CreateBookingDTO bookingRequest) {

        // Validate if booking is open
        if (!bookingRequest.getShow().isShowPending()) {
            throw new RuntimeException("Booking for this movie is closed!");
        }

        lock.lock();
        /*
        This ensures that only one thread can acquire the lock at a time.
        This means that if multiple threads try to execute this code concurrently,
        only one will be allowed into the critical section, while others will wait.
        This prevents multiple threads from concurrently modifying seat availability or creating bookings,
        which could lead to data inconsistencies or race conditions.
         */
        try {
            // ==================== Critical Section START ============
            boolean isOccupied = checkIfSeatIsOccupied(bookingRequest.getShowSeats());
            // Early returns
            if (isOccupied) {
                throw new RuntimeException("Seat is already booked!");
            }

            // Go ahead and book
            // Mark the seat as FILLED
            for (ShowSeat seat : bookingRequest.getShowSeats()) {
                seat.setOccupied(true);
                showSeatService.save(seat);
            }
            // ==================== Critical Section END ============
        } finally {
            lock.unlock();
            /*
            This is important because if an exception occurs within the critical section,
            the lock should still be released.
             */
        }
        // Create and persist booking
        Customer customer = customerService.getCustomer(bookingRequest.getCustomerId());
        Booking booking = new Booking(customer, bookingRequest.getShow());
        booking.setSeatsBooked(bookingRequest.getShowSeats());
        return bookingRepository.save(booking);
    }

    public boolean checkIfSeatIsOccupied(List<ShowSeat> seats) {
        for (ShowSeat seat : seats) {
            if (showSeatService.isOccupied(seat)) {
                return true;
            }
        }
        return false;
    }

}
