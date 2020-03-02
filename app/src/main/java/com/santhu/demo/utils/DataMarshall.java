package com.santhu.demo.utils;

public class DataMarshall {

    //TODO country should come from server
    public static String convertMoney(final String price, final String country){

        // for demo we are just adde POUND as currency

        return "£"+price;
    }

}
