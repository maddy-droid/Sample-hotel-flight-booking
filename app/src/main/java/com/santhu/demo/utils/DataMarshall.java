package com.santhu.demo.utils;

import com.santhu.demo.model.Flight;
import com.santhu.demo.model.HotelDetails;

public class DataMarshall {

    //TODO country should come from server
    public static String convertMoney(final String price, final String country){

        // for demo we are just adde POUND as currency

        return "£"+price;
    }

    public static String combinePassengerData(String deperature, String destination, String dateDep, String dateDest ){
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(destination+"!");
        stringBuffer.append(destination+"!");

        stringBuffer.append(dateDep+"!");
        stringBuffer.append(dateDep+"!");

        return stringBuffer.toString();
    }

    public static String[] splitPassengerData(String passengerData){
        String[] data = passengerData.split("!");
        return data;
    }


    public static String combineFlightData(Flight flight){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(flight.getAirline()+"!");
        stringBuffer.append(flight.getDeparture_date()+"!");

        stringBuffer.append(flight.getDeparture_airport()+"!");
        stringBuffer.append(flight.getArrival_date()+"!");

        stringBuffer.append(flight.getArrival_airport()+"!");
        stringBuffer.append(flight.getPrice());

        return stringBuffer.toString();
    }

    public static String[] splitFlightData(String flightData){
        String[] data = flightData.split("!");
        return data;
    }


    public static String combineHotelData(HotelDetails hotelDetails){
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(hotelDetails.getName()+"!");
        stringBuffer.append(hotelDetails.getDescription());

        return stringBuffer.toString();
    }

    public static String[] splitHotelData(String hotelDetails){
        String[] data = hotelDetails.split("!");
        return data;
    }

}
