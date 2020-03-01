package com.santhu.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flight {

    @SerializedName("airline")
    @Expose
    private String airline;

    @SerializedName("departure_date")
    @Expose
    private String departure_date;

    @SerializedName("arrival_date")
    @Expose
    private String arrival_date;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("departure_airport")
    @Expose
    private String departure_airport;

    @SerializedName("arrival_airport")
    @Expose
    private String arrival_airport;

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(String departure_date) {
        this.departure_date = departure_date;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }
}
