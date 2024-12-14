package com.example.movieticketbooking.workflow;

import com.example.movieticketbooking.activities.MovieTicketActivities;
import com.example.movieticketbooking.model.MovieTicket;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class MovieTicketWorkflowImpl implements MovieTicketWorkflow {

    @Autowired
    private MovieTicketActivities movieTicketActivities;

    @Override
    public String processBooking(MovieTicket ticket) {
        // Create activity options with a timeout of 5 minutes
        ActivityOptions options = ActivityOptions.newBuilder()
                .setScheduleToCloseTimeout(Duration.ofMinutes(5))
                .build();

        // Set activity options for the activities
        movieTicketActivities = Workflow.newActivityStub(MovieTicketActivities.class, options);

        // Call the activities in sequence
        movieTicketActivities.paymentProcessing(ticket);
        movieTicketActivities.inventoryUpdate(ticket);
        movieTicketActivities.bookingConfirmation(ticket);

        // Return a confirmation message
        return "Booking successfully processed for " + ticket.getMovieName() + " at " + ticket.getTheatreName();  // Use getTheatreName() instead of getTheatre()
    }
}
