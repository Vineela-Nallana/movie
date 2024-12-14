package com.example.movieticketbooking.activities;

import com.example.movieticketbooking.model.MovieTicket;
import org.springframework.stereotype.Component;

@Component
public class MovieTicketActivitiesImpl implements  MovieTicketActivities {

    @Override
    public void paymentProcessing(MovieTicket ticket) {
        // Simulate payment processing logic
        System.out.println("Processing payment for ticket: " + ticket);
        ticket.setPaymentStatus("Processed");
    }

    @Override
    public void inventoryUpdate(MovieTicket ticket) {
        // Simulate inventory update (e.g., seat availability)
        System.out.println("Updating inventory for ticket: " + ticket);
        // Assuming inventory update logic here (seat booked)
    }

    @Override
    public void bookingConfirmation(MovieTicket ticket) {
        // Simulate booking confirmation
        System.out.println("Confirming booking for ticket: " + ticket);
        ticket.setPaymentStatus("Confirmed");
    }
}
