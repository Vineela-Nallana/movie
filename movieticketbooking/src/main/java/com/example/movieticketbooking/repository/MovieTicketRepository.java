package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.model.MovieTicket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTicketRepository extends MongoRepository<MovieTicket, String> {
}
