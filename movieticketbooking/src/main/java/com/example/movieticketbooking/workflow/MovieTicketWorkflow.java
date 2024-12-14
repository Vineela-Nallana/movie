package com.example.movieticketbooking.workflow;

import com.example.movieticketbooking.model.MovieTicket;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface MovieTicketWorkflow {

    // This method will be invoked by the workflow stub
    @WorkflowMethod
    String processBooking(MovieTicket ticket);  // Return a String to indicate the result
}
