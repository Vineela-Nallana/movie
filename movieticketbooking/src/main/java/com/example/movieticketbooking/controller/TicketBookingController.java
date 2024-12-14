package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.model.MovieTicket;
import com.example.movieticketbooking.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket-booking")
public class TicketBookingController {

    @Autowired
    private MovieTicketService movieTicketService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody MovieTicket ticket) {
        // Save ticket to MongoDB and process the booking
        String bookingStatus = movieTicketService.bookMovieTicket(ticket);
        return bookingStatus;  // Returning the status or result from the service layer
    }
}
