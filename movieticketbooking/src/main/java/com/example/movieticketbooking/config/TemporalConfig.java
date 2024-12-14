package com.example.movieticketbooking.config;

import com.example.movieticketbooking.activities.MovieTicketActivitiesImpl;
import com.example.movieticketbooking.workflow.MovieTicketWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporalConfig {

    @Bean
    public WorkflowClient workflowClient() {
        // Connect to the Temporal service running at localhost:7233
        WorkflowServiceStubs serviceStubs = WorkflowServiceStubs.newInstance();  // No need for WorkflowServiceStubsOptions

        // Create and return the WorkflowClient
        return WorkflowClient.newInstance(serviceStubs);
    }

    @Bean
    public Worker startWorker(WorkflowClient workflowClient) {
        // Create a WorkerFactory with the workflow client
        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);

        // Create a Worker for a specific task queue
        Worker worker = factory.newWorker("movie-ticket-queue");

        // Register the workflow and activities with the worker
        worker.registerWorkflowImplementationTypes(MovieTicketWorkflowImpl.class);
        worker.registerActivitiesImplementations(new MovieTicketActivitiesImpl());

        // Start the worker to process workflows and activities
        factory.start();

        return worker;  // Return the worker
    }
}
