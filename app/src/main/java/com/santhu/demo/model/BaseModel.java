package com.santhu.demo.model;

public class BaseModel {

    private int type;

    private HotelDetails hotelDetails;

    private FlightDetails flightDetails;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public HotelDetails getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(HotelDetails hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public FlightDetails getFlightDetails() {
        return flightDetails;
    }

    public void setFlightDetails(FlightDetails flightDetails) {
        this.flightDetails = flightDetails;
    }
}
