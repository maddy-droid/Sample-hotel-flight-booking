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

}
