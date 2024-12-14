package com.example.movieticketbooking.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie_tickets")
public class MovieTicket {

    private String movieName;
    private String theatreName;
    private String seatNumber;
    private String paymentStatus;

    // Getters and Setters

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "MovieTicket{" +
                "movieName='" + movieName + '\'' +
                ", theatreName='" + theatreName + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
