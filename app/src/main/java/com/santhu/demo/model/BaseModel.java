package com.santhu.demo.model;

public class BaseModel {

    private int type;

    private HotelDetails hotelDetails;


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
}
