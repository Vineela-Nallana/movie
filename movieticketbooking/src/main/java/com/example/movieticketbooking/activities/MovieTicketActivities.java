package com.example.movieticketbooking.activities;

import com.example.movieticketbooking.model.MovieTicket;
import io.temporal.activity.ActivityMethod;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface MovieTicketActivities {
    @ActivityMethod
    void paymentProcessing(MovieTicket ticket);
    @ActivityMethod
    void inventoryUpdate(MovieTicket ticket);
    @ActivityMethod
    void bookingConfirmation(MovieTicket ticket);
}
