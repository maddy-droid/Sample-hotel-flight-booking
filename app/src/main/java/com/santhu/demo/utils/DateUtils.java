package com.santhu.demo.utils;

import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateUtils {

    public final static String DATE_TIME_FORMAT_MMMM_DD_EEEE = "MMMM dd, EEEE yyyy";
    public final static String DATE_TIME_FORMAT_YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";
    private static Map<String,SimpleDateFormat> stringDateFormatMap = new HashMap<>();


    public static String getDate(String currentDate){
        if (currentDate == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        try {
            DateFormat Iso8061Format = getDateFormatObject(DATE_TIME_FORMAT_YYYY_MM_DD_T_HH_MM_SS); //input format
            Date date = Iso8061Format.parse(currentDate);
            DateFormat resultFormat = getDateFormatObject(DATE_TIME_FORMAT_MMMM_DD_EEEE);
            builder.append(resultFormat.format(date));
        }catch (ParseException e){
            Log.e("HAF","unable to parse time date for weather");
        }
        return builder.toString();
    }


    public static SimpleDateFormat getDateFormatObject(String datePattern) {
        SimpleDateFormat simpleDateFormat;
        if (!stringDateFormatMap.containsKey(datePattern) && stringDateFormatMap.get(datePattern) == null) {
            simpleDateFormat = new SimpleDateFormat(datePattern, Locale.ENGLISH);
            stringDateFormatMap.put(datePattern, simpleDateFormat);
        } else {
            simpleDateFormat = stringDateFormatMap.get(datePattern);
        }
        return simpleDateFormat;
    }


}
