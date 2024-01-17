package com.jatin.popcornTime.controllers;

import com.jatin.popcornTime.dtos.CreateBookingDTO;
import com.jatin.popcornTime.models.Booking;
import com.jatin.popcornTime.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public Booking bookTicket(CreateBookingDTO bookingRequest) {

        return bookingService.bookTicket(bookingRequest);
    }
}