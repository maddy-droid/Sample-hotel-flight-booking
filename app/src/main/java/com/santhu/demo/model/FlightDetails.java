package com.santhu.demo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FlightDetails extends BaseModel {

    @SerializedName("flights")
    @Expose
    private ArrayList<Flight> flights;

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
}
